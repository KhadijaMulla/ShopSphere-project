package com.shopsphere.shop.repository;

import com.shopsphere.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
      User findByEmail(String email);
}