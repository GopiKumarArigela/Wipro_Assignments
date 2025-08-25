package com.example.gk.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gk.paymentservice.entities.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderId(Long orderId);
}
