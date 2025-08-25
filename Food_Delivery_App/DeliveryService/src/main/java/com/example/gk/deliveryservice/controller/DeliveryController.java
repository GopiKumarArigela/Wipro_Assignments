package com.example.gk.deliveryservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.gk.deliveryservice.dto.DeliveryRequestDTO;
import com.example.gk.deliveryservice.dto.DeliveryResponseDTO;
import com.example.gk.deliveryservice.entities.DeliveryStatus;
import com.example.gk.deliveryservice.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery")
    public ResponseEntity<DeliveryResponseDTO> createDelivery(@Valid @RequestBody DeliveryRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(deliveryService.createDelivery(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponseDTO> getDelivery(@PathVariable Long id) {
        return ResponseEntity.ok(deliveryService.getDelivery(id));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<DeliveryResponseDTO>> getByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(deliveryService.getByOrder(orderId));
    }

    @PatchMapping("/{id}/status/{status}")
    public ResponseEntity<DeliveryResponseDTO> updateStatus(@PathVariable Long id,
                                                            @PathVariable DeliveryStatus status) {
        return ResponseEntity.ok(deliveryService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}
