package com.example.gk.messageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gk.messageservice.entities.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderId(Long senderId);
    List<Message> findByReceiverId(Long receiverId);
    List<Message> findByOrderId(Long orderId);
}