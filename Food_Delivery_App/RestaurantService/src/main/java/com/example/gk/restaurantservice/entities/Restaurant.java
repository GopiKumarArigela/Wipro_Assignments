package com.example.gk.restaurantservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Restaurant name cannot be blank")
    private String name;

    private String location;

    // Menu stored inside Restaurant
    @ElementCollection
    @CollectionTable(name = "restaurant_menu", joinColumns = @JoinColumn(name = "restaurant_id"))
    private List<MenuItem> menuList;

    @Embeddable
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MenuItem {
        private String itemName;
        private Double price;
    }
}