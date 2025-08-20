package com.adobe.prj.client;

import com.adobe.prj.dao.PersitenceException;
import com.adobe.prj.dao.ProductRepo;
import com.adobe.prj.dao.ProductRepoJdbcImpl;
import com.adobe.prj.entity.Product;

public class InsertProductClient {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepoJdbcImpl();
        Product product = new Product(0, "LG AC", 54000.00);

        try {
            productRepo.addProduct(product);
            System.out.println("Product added!!!");
        } catch (PersitenceException e) {
        //    System.out.println(e.getMessage()); // end user
           e.printStackTrace(); // developer
        }
    }
}
