package com.shopsphere.shop.repository;

import com.shopsphere.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByBrandIgnoreCase(String brand);

    List<Product> findByCategoryNameIgnoreCase(String name);
}