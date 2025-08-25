package com.example.gk.orderservice.datatransferobject;

import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderResponseDTO {

    private Long id;
    private String orderNumber;
    private Long customerId;
    private Long restaurantId;
    private LocalDateTime orderDate;
    private String status;
    private String notes;
    private BigDecimal totalAmount;
    private List<OrderItemResponseDTO> items;
	
}
