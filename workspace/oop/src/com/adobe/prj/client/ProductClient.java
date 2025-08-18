package com.adobe.prj.client;

import com.adobe.prj.entity.Mobile;
import com.adobe.prj.entity.Product;
import com.adobe.prj.entity.Tv;

import java.lang.reflect.Method;

public class ProductClient {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Mobile(34, "MotoG", 5000.00, "5G");
        products[1] = new Tv(51, "Onida Thunder", 3500, "CRT");
        products[2] = new Tv(91, "Sony Bravia", 2_90_000.00, "OLED");
        products[3] = new Mobile(91, "iPhone 16", 89000.00, "5G");

        // mobile[]
        // tv[]
        // for loop for mobile
        // for loop for tv
        // dishwasher[]
        // for loop for dishwasher
        printExpensiveProducts(products);
//      printDetails(products);
        printDetailsOCP(products);
    }

    // OCP
    private static void printDetailsOCP(Product[] products) {
        for(Product p : products) {
            System.out.println("*****");
            Class clazz =  p.getClass(); // get class data from header in heap area
            // using RTTI, Reflection API
            Method[] methods = clazz.getMethods(); // methods of class + inherited
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    try {
                        Object ret = m.invoke(p); // reflection API
                        System.out.println(m.getName().substring(3).toUpperCase() + " : " + ret);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
            System.out.println("########");
        }
    }

    // is this OCP? NO
    private static void printDetails(Product[] products) {
        for(Product p : products) {
            System.out.println(p.getName() + ", " + p.getPrice());
            // type checking before casting
            if(p instanceof Mobile) {
                Mobile m = (Mobile) p; // down-casting, casting operator is a must
                System.out.println(m.getConnectivity());
            } //else if(p instanceof  Tv) {
            else if(p.getClass() == Tv.class) { // more strict checking
                Tv tv = (Tv) p; // down-casting
                System.out.println(tv.getScreenType());
            }
        }
    }

    // OCP
    private static void printExpensiveProducts(Product[] products) {
        for(Product p : products) {
            // polymorphism - dynamic binding, invoke mobile / tv / dishwasher
            if(p.isExpensive()) {
                System.out.println(p.getName() + " is Expensive !!!" );
            } else {
                System.out.println(p.getName() + " is not expensive!!!");
            }
        }
    }
}
