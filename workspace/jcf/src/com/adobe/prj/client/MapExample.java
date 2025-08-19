package com.adobe.prj.client;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Double> bookPrices = new HashMap<>();
        bookPrices.put("JavaScript", 890.22);
        bookPrices.put("Oracle Ref", 9013.11);
        bookPrices.put("Head First Java", 800.00);

        bookPrices.put("JavaScript", 2890.20); // overwrites the value

        System.out.println(bookPrices.get("JavaScript"));

        bookPrices.forEach( (k,v) -> {
            System.out.println("Book " + k + " Value " + v);
        });
    }
}
