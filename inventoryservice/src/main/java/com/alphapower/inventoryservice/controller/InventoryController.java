package com.alphapower.inventoryservice.controller;

import com.alphapower.inventoryservice.dto.InventoryRequest;
import com.alphapower.inventoryservice.dto.InventoryResponse;
import com.alphapower.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping
    public InventoryResponse createInventory(@RequestBody InventoryRequest request) {
        return inventoryService.createInventory(request);
    }

    @GetMapping("/{productId}")
    public InventoryResponse getInventory(@PathVariable Long productId) {
        return inventoryService.getInventoryByProductId(productId);
    }

    @PutMapping("/{productId}")
    public InventoryResponse updateStock(
            @PathVariable Long productId,
            @RequestParam Integer stock) {

        return inventoryService.updateStock(productId, stock);
    }
}