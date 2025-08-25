package com.example.gk.orderservice.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private Integer quantity;
    private BigDecimal unitPrice;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
