package com.adobe.ecomapp.repo;

import com.adobe.ecomapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
