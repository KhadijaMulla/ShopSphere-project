package com.shopsphere.shop.dto;

import com.shopsphere.shop.entity.Order;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {

        return new OrderDTO(
                order.getId(),
                order.getUser().getId(),
                order.getStatus(),
                order.getTotalAmount()
        );
    }
}