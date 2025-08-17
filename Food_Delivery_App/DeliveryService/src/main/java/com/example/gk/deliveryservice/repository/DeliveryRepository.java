package com.example.gk.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gk.deliveryservice.entities.Delivery;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByOrderId(Long orderId);
}
