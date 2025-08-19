package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Product> products = new HashSet<>(16, 0.7f);
        products.add(new Product(92, "Samsung Fold", 1_20_000.00, "mobile"));
        products.add(new Product(71, "LG AC", 45000.00, "electronics"));
        products.add( new Product(76, "Wacom", 4000.00, "computer"));
        products.add(new Product(12, "iPhone", 99_000.00, "mobile"));
        products.add(new Product(34, "Logitech Mouse", 800.00, "computer"));
        products.add( new Product(76, "Wacom", 4000.00, "computer"));
        products.add(new Product(71, "LG AC", 45000.00, "electronics"));

        for(Product p : products) {
            System.out.println(p);
        }

        // Collections are inter changeable
        List<Product> productList = new ArrayList<>(products); // Set to List
        Collections.sort(productList);
        Collections.reverse(productList);
        Collections.shuffle(productList);

    }
}
