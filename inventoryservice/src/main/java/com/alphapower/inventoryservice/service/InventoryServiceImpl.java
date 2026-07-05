package com.alphapower.inventoryservice.service;

import com.alphapower.inventoryservice.dto.InventoryRequest;
import com.alphapower.inventoryservice.dto.InventoryResponse;
import com.alphapower.inventoryservice.entity.Inventory;
import com.alphapower.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryResponse createInventory(InventoryRequest request) {

        Inventory inventory = Inventory.builder()
                .productId(request.getProductId())
                .stock(request.getStock())
                .build();

        inventoryRepository.save(inventory);

        return InventoryResponse.builder()
                .id(inventory.getId())
                .productId(inventory.getProductId())
                .stock(inventory.getStock())
                .build();
    }

    @Override
    public InventoryResponse getInventoryByProductId(Long productId) {

        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        return InventoryResponse.builder()
                .id(inventory.getId())
                .productId(inventory.getProductId())
                .stock(inventory.getStock())
                .build();
    }

    @Override
    public InventoryResponse updateStock(Long productId, Integer stock) {

        Inventory inventory = inventoryRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));

        inventory.setStock(stock);

        inventoryRepository.save(inventory);

        return InventoryResponse.builder()
                .id(inventory.getId())
                .productId(inventory.getProductId())
                .stock(inventory.getStock())
                .build();
    }
}