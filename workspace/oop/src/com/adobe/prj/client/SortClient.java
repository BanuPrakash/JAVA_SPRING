package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;
import com.adobe.prj.util.Utility;

public class SortClient {
    public static void main(String[] args) {
        String[] names = {"Scarlett", "George", "Anne","Brad", "Angelina", "Travolta"};

        Utility.sort(names);

        for(String name : names) {
            System.out.println(name);
        }

        Product[] products = new Product[4];
        products[0] = new Mobile(34, "MotoG", 5000.00, "5G"); //up casting
        products[1] = new Tv(51, "Onida Thunder", 3500, "CRT");
        products[2] = new Tv(91, "Sony Bravia", 2_90_000.00, "OLED");
        products[3] = new Mobile(91, "iPhone 16", 89000.00, "5G");

        Utility.sort(products);

        for(Product p : products) {
            System.out.println(p); //toString()
        }
    }
}
