package com.adobe.ecomapp.repo;

import com.adobe.ecomapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
