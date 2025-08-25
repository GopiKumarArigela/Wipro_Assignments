package com.example.gk.deliveryservice.dto;

import lombok.*;

import java.time.LocalDateTime;

import com.example.gk.deliveryservice.entities.DeliveryStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryResponseDTO {

    private Long id;
    private Long orderId;
    private String deliveryAddress;
    private LocalDateTime deliveryDate;
    private DeliveryStatus status;
    private String notes;
}
