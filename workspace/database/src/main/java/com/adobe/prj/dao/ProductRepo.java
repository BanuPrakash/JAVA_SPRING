package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductRepo {
    List<Product> getProducts();
    void addProduct(Product product) throws PersitenceException;
    Product getProduct(int id);
}
