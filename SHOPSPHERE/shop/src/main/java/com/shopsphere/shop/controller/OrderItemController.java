package com.shopsphere.shop.controller;

import com.shopsphere.shop.entity.OrderItem;
import com.shopsphere.shop.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public OrderItem getOrderItemById(@PathVariable int id) {
        return orderItemService.getOrderItemById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
    }
}