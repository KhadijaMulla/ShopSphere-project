// package com.shopsphere.shop.service;

// import com.shopsphere.shop.entity.Order;
// import com.shopsphere.shop.repository.OrderRepository;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class OrderService {

//     private final OrderRepository orderRepository;

//     public OrderService(OrderRepository orderRepository) {
//         this.orderRepository = orderRepository;
//     }

//     public Order createOrder(Order order) {
//         return orderRepository.save(order);
//     }

//     public List<Order> getAllOrders() {
//         return orderRepository.findAll();
//     }

//     public Order getOrderById(int id) {
//         return orderRepository.findById(id).orElse(null);
//     }

//     public void deleteOrder(int id) {
//         orderRepository.deleteById(id);
//     }
// }
// package com.shopsphere.shop.service;

// import com.shopsphere.shop.dto.OrderDTO;
// import com.shopsphere.shop.dto.OrderMapper;
// import com.shopsphere.shop.entity.Order;
// import com.shopsphere.shop.repository.OrderRepository;

// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class OrderService {

//     private final OrderRepository orderRepository;

//     public OrderService(OrderRepository orderRepository) {
//         this.orderRepository = orderRepository;
//     }

//     public Order createOrder(Order order) {
//         return orderRepository.save(order);
//     }

//     public List<OrderDTO> getAllOrders() {

//         List<Order> orders = orderRepository.findAll();

//         return orders.stream()
//                 .map(OrderMapper::toDTO)
//                 .toList();
//     }

//     public Optional<OrderDTO> getOrderById(int id) {

//         Optional<Order> order = orderRepository.findById(id);

//         if (order.isPresent()) {
//             return Optional.of(OrderMapper.toDTO(order.get()));
//         }

//         return Optional.empty();
//     }

//     public void deleteOrder(int id) {
//         orderRepository.deleteById(id);
//     }
// }
package com.shopsphere.shop.service;

import com.shopsphere.shop.entity.Order;
import com.shopsphere.shop.exception.ResourceNotFoundException;
import com.shopsphere.shop.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id: " + id));
    }

    public void deleteOrder(int id) {

        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Order not found with id: " + id);
        }

        orderRepository.deleteById(id);
    }
}