package com.example.gk.messageservice.dto;

import lombok.*;

import jakarta.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageRequestDTO {
    private Long senderId;
    private Long receiverId;
    private Long orderId;
    private Long paymentId;
    private Long deliveryId;

    @NotBlank(message = "Message content cannot be blank")
    private String content;
}
