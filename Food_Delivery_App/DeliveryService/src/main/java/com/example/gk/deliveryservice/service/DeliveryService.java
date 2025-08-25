package com.example.gk.deliveryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gk.deliveryservice.dto.DeliveryRequestDTO;
import com.example.gk.deliveryservice.dto.DeliveryResponseDTO;
import com.example.gk.deliveryservice.entities.Delivery;
import com.example.gk.deliveryservice.entities.DeliveryStatus;
import com.example.gk.deliveryservice.exception.ResourceNotFoundException;
import com.example.gk.deliveryservice.repository.DeliveryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Transactional
    public DeliveryResponseDTO createDelivery(DeliveryRequestDTO request) {
        Delivery delivery = Delivery.builder()
                .orderId(request.getOrderId())
                .deliveryAddress(request.getDeliveryAddress())
                .status(request.getStatus() != null ? DeliveryStatus.valueOf(request.getStatus()) : DeliveryStatus.PENDING)
                .notes(request.getNotes())
                .deliveryDate(LocalDateTime.now())
                .build();

        Delivery saved = deliveryRepository.save(delivery);
        return mapToDTO(saved);
    }

    public DeliveryResponseDTO getDelivery(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id: " + id));
        return mapToDTO(delivery);
    }

    public List<DeliveryResponseDTO> getByOrder(Long orderId) {
        return deliveryRepository.findByOrderId(orderId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public DeliveryResponseDTO updateStatus(Long id, DeliveryStatus status) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id: " + id));
        delivery.setStatus(status);
        return mapToDTO(deliveryRepository.save(delivery));
    }

    @Transactional
    public void deleteDelivery(Long id) {
        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id: " + id));
        deliveryRepository.delete(delivery);
    }

    private DeliveryResponseDTO mapToDTO(Delivery delivery) {
        return DeliveryResponseDTO.builder()
                .id(delivery.getId())
                .orderId(delivery.getOrderId())
                .deliveryAddress(delivery.getDeliveryAddress())
                .deliveryDate(delivery.getDeliveryDate())
                .status(delivery.getStatus())
                .notes(delivery.getNotes())
                .build();
    }
}
