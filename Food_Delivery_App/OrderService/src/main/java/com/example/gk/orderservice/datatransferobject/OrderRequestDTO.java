package com.example.gk.orderservice.datatransferobject;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {

    @NotNull
    private Long customerId;

    @NotNull
    private Long restaurantId;

    private String notes;

    @Size(min = 1, message = "Order must contain at least one item")
    private List<OrderItemRequestDTO> items;
}