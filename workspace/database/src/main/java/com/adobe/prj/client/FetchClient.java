package com.adobe.prj.client;

import com.adobe.prj.dao.ProductRepo;
import com.adobe.prj.dao.ProductRepoJdbcImpl;
import com.adobe.prj.entity.Product;

import java.util.List;

public class FetchClient {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepoJdbcImpl(); // use factory
        List<Product> products = productRepo.getProducts();
        for(Product p  : products) {
            System.out.println(p);
        }
    }
}
