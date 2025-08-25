package com.example.gk.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gk.paymentservice.dto.PaymentRequestDTO;
import com.example.gk.paymentservice.dto.PaymentResponseDTO;
import com.example.gk.paymentservice.entities.Payment;
import com.example.gk.paymentservice.exception.ResourceNotFoundException;
import com.example.gk.paymentservice.repository.PaymentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public PaymentResponseDTO makePayment(PaymentRequestDTO request) {
        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .paymentMethod(request.getPaymentMethod())
                .paymentDate(LocalDateTime.now())
                .status("SUCCESS")
                .build();

        Payment saved = paymentRepository.save(payment);
        return toResponseDTO(saved);
    }

    public PaymentResponseDTO getPaymentById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + paymentId));
        return toResponseDTO(payment);
    }

    public List<PaymentResponseDTO> getPaymentsByOrder(Long orderId) {
        return paymentRepository.findByOrderId(orderId)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + paymentId));
        paymentRepository.delete(payment);
    }

    private PaymentResponseDTO toResponseDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrderId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setStatus(payment.getStatus());
        return dto;
    }
}
