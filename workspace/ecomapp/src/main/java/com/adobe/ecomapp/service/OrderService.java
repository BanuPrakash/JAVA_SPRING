package com.adobe.ecomapp.service;

import com.adobe.ecomapp.entity.LineItem;
import com.adobe.ecomapp.entity.Order;
import com.adobe.ecomapp.entity.Product;
import com.adobe.ecomapp.repo.OrderRepo;
import com.adobe.ecomapp.repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private  final OrderRepo orderRepo;
    private  final ProductRepo productRepo;

    /*
        {
            "customer": {"email":"rita@adobe.com"},
            "items": [
                    {"product": {"id": 2}, qty: 1},
                    {"product": {"id": 1}, "qty": 2}
            ]
        }
        Item's amount has to be calculated = qty * price - discount + GST
        orders total has to be calculated
        Product's inventory has to be reduced
     */
    @Transactional
    public  String placeOrder(Order order) {
        double total = 0.0;
        Set<LineItem> items = order.getItems();
        for(LineItem item: items) {
            Product p = productRepo.findById(item.getProduct().getId()).get();
            item.setAmount(p.getPrice() * item.getQty()); // add tax, discount
            p.setQuantity( p.getQuantity() - item.getQty() ); // dirty checking
            if(p.getQuantity() < 0) {
                throw  new IllegalArgumentException("Product " + p.getName() + " not is stock!!!");
            }
            total += item.getAmount();
        }
        order.setTotal(total);
        orderRepo.save(order); // order and line items are saved --> CASCADE
        return "Order placed!!";
    }
}
