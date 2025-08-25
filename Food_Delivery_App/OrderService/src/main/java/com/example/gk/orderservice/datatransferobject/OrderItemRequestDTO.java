package com.example.gk.orderservice.datatransferobject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItemRequestDTO {

    @NotBlank(message = "Item name is required")
    private String itemName;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;

    @Min(value = 1, message = "Unit price must be at least 1")
    private BigDecimal unitPrice;
}