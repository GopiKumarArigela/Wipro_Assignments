package com.example.gk.messageservice.dto;

import java.time.LocalDateTime;

import com.example.gk.messageservice.enums.MessageStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageResponseDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private Long orderId;
    private Long paymentId;
    private Long deliveryId;
    private MessageStatus status;
    private String content;
    private LocalDateTime timestamp;
}
