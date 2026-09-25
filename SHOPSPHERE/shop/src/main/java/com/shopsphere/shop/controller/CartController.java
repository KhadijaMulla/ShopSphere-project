package com.shopsphere.shop.controller;

import com.shopsphere.shop.entity.Cart;
import com.shopsphere.shop.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable int id) {
        return cartService.getCartById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
    }
}