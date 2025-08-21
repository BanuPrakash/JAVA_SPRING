package com.adobe.ecomapp.client;

import com.adobe.ecomapp.entity.Customer;
import com.adobe.ecomapp.entity.LineItem;
import com.adobe.ecomapp.entity.Order;
import com.adobe.ecomapp.entity.Product;
import com.adobe.ecomapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderClient implements CommandLineRunner {
    private final OrderService service;
    @Override
    public void run(String... args) throws Exception {
        Order order = new Order();
        order.setCustomer(Customer.builder().email("rita@adobe.com").build());
        LineItem i1 = new LineItem();
        i1.setProduct(Product.builder().id(2).build());
        i1.setQty(1);

        LineItem i2 = new LineItem();
        i2.setProduct(Product.builder().id(1).build());
        i2.setQty(2);

        order.getItems().add(i1);
        order.getItems().add(i2);
        System.out.println(service.placeOrder(order));
    }
}
