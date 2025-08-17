package com.example.gk.deliveryservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeliveryRequestDTO {

    private Long orderId; // add this if your Delivery entity has orderId

    @NotBlank(message = "Delivery address is required")
    private String deliveryAddress;

    private String notes; // optional notes field

    private String status; // optional, will map to DeliveryStatus enum
}
