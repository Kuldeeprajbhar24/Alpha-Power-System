package com.alphapower.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private Long productId;

    private Integer quantity;

    private Double totalPrice;
}