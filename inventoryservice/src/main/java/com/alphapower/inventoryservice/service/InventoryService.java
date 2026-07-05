package com.alphapower.inventoryservice.service;

import com.alphapower.inventoryservice.dto.InventoryRequest;
import com.alphapower.inventoryservice.dto.InventoryResponse;

public interface InventoryService {

    InventoryResponse createInventory(InventoryRequest request);

    InventoryResponse getInventoryByProductId(Long productId);

    InventoryResponse updateStock(Long productId, Integer stock);
}