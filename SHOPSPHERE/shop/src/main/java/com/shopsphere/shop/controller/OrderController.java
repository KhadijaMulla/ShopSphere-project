// // package com.shopsphere.shop.controller;

// // import com.shopsphere.shop.entity.Order;
// // import com.shopsphere.shop.service.OrderService;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/orders")
// // public class OrderController {

// //     private final OrderService orderService;

// //     public OrderController(OrderService orderService) {
// //         this.orderService = orderService;
// //     }

// //     @PostMapping
// //     public Order createOrder(@RequestBody Order order) {
// //         return orderService.createOrder(order);
// //     }

// //     @GetMapping
// //     public List<Order> getAllOrders() {
// //         return orderService.getAllOrders();
// //     }

// //     @GetMapping("/{id}")
// //     public Order getOrderById(@PathVariable int id) {
// //         return orderService.getOrderById(id);
// //     }

// //     @DeleteMapping("/{id}")
// //     public void deleteOrder(@PathVariable int id) {
// //         orderService.deleteOrder(id);
// //     }
// // }
// package com.shopsphere.shop.controller;

// import com.shopsphere.shop.dto.OrderDTO;
// import com.shopsphere.shop.entity.Order;
// import com.shopsphere.shop.service.OrderService;

// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/orders")
// public class OrderController {

//     private final OrderService orderService;

//     public OrderController(OrderService orderService) {
//         this.orderService = orderService;
//     }

//     @PostMapping
//     public Order createOrder(@RequestBody Order order) {
//         return orderService.createOrder(order);
//     }

//     @GetMapping
//     public List<OrderDTO> getAllOrders() {
//         return orderService.getAllOrders();
//     }

//     @GetMapping("/{id}")
//     public Optional<OrderDTO> getOrderById(@PathVariable int id) {
//         return orderService.getOrderById(id);
//     }

//     @DeleteMapping("/{id}")
//     public void deleteOrder(@PathVariable int id) {
//         orderService.deleteOrder(id);
//     }
// }
package com.shopsphere.shop.controller;

import com.shopsphere.shop.entity.Order;
import com.shopsphere.shop.service.OrderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}