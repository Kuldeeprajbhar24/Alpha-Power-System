package com.alphapower.inventoryservice.dto;

import lombok.Data;

@Data
public class InventoryRequest {

    private Long productId;
    private Integer stock;
}