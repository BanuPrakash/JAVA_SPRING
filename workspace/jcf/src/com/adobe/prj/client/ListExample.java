package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(); // use generics and interface
        addProducts(products);
//      Collections.sort(products);
        Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        printProducts(products);
    }

    private static void printProducts(List<Product> products) {
        for(Product p : products) {
            System.out.println(p);
        }
    }

    private static void addProducts(List<Product> products) {
        products.add(new Product(92, "Samsung Fold", 1_20_000.00, "mobile"));
        products.add(new Product(71, "LG AC", 45000.00, "electronics"));
        products.add( new Product(76, "Wacom", 4000.00, "computer"));
        products.add(new Product(12, "iPhone", 99_000.00, "mobile"));
        products.add(new Product(34, "Logitech Mouse", 800.00, "computer"));
    }
}
