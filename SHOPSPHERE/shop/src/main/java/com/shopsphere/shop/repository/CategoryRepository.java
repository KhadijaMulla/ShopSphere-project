package com.shopsphere.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopsphere.shop.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}