package com.shopsphere.shop.service;

import com.shopsphere.shop.entity.CartItem;
import com.shopsphere.shop.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    public void deleteCartItem(int id) {
        cartItemRepository.deleteById(id);
    }
}