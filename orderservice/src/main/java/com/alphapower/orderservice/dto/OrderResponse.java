package com.alphapower.orderservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderResponse {

    private Long id;

    private Long productId;

    private Integer quantity;

    private Double totalPrice;

    private String status;

    private LocalDateTime orderDate;
}