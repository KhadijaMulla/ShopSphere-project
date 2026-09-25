package com.shopsphere.shop.controller;

import com.shopsphere.shop.entity.CartItem;
import com.shopsphere.shop.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public CartItem createCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.createCartItem(cartItem);
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public CartItem getCartItemById(@PathVariable int id) {
        return cartItemService.getCartItemById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable int id) {
        cartItemService.deleteCartItem(id);
    }
}