package com.example.gk.messageservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

import com.example.gk.messageservice.enums.MessageStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long senderId;     // Customer, Restaurant, or System

    private Long receiverId;   // Customer, Restaurant, or System

    private Long orderId;      // Optional

    private Long paymentId;    // Optional

    private Long deliveryId;   // Optional

    @Enumerated(EnumType.STRING)
    private MessageStatus status; // SENT, DELIVERED, READ

    @NotBlank(message = "Message content cannot be blank")
    private String content;

    private LocalDateTime timestamp;
}
