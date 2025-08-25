package com.example.gk.orderservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gk.orderservice.entities.*;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByRestaurantId(Long restaurantId);
}

