package com.shopsphere.shop.service;

import com.shopsphere.shop.entity.Cart;
import com.shopsphere.shop.entity.User;
import com.shopsphere.shop.repository.CartRepository;
import com.shopsphere.shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public Cart createCart(Cart cart) {
        User user = userRepository.findById(cart.getUser().getId()).orElse(null);

        if (user != null) {
            cart.setUser(user);
            return cartRepository.save(cart);
        }

        return null;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(int id) {
        return cartRepository.findById(id).orElse(null);
    }



















































    
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}