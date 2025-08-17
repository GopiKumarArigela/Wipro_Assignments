package com.example.gk.orderservice.datatransferobject;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItemResponseDTO {

    private String itemName;
    private Integer quantity;
    private BigDecimal unitPrice;
}