package com.adobe.prj.client;

import com.adobe.prj.entity.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysClient {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product(92, "Samsung Fold", 1_20_000.00, "mobile");
        products[1] = new Product(71, "LG AC", 45000.00, "electronics");
        products[2] = new Product(76, "Wacom", 4000.00, "computer");
        products[3] = new Product(12, "iPhone", 99_000.00, "mobile");
        products[4] = new Product(34, "Logitech Mouse", 800.00, "computer");

        String[] names = {"Harry", "Kim", "Peter", "Hathaway", "Angelina", "Scarlett", "Brad"};

        Arrays.sort(names);

        for(String name : names) {
            System.out.println(name);
        }

        Arrays.sort(products);
        for(Product p: products) {
            System.out.println(p); // toString()
        }

        System.out.println("Client needs Names sorted by length...");
        // Option 1
        // Arrays.sort(names, new LengthComparator()); // client specific

        // Option 2:
        // anonymous class
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });

        // option 3:
        // lambda expression
        Arrays.sort(names, (String o1, String o2) -> o1.length() - o2.length());

        for(String name : names) {
            System.out.println(name);
        }

        // Task 1:
        // Arrays.sort(products, lambda to sort products based on price
        // print

        // Task 2:
        // Arrays.sort(products, lambda to sort products based on name
        // print
    }
}
