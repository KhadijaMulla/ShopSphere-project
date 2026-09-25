package com.shopsphere.shop.service;

import com.shopsphere.shop.entity.OrderItem;
import com.shopsphere.shop.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem getOrderItemById(int id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public void deleteOrderItem(int id) {
        orderItemRepository.deleteById(id);
    }
}