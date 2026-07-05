package com.alphapower.orderservice.service;

import com.alphapower.orderservice.dto.OrderRequest;
import com.alphapower.orderservice.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest request);

    OrderResponse getOrderById(Long id);

    List<OrderResponse> getAllOrders();
}