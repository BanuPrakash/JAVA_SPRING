package com.adobe.prj.dao;

import com.adobe.prj.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoJdbcImpl implements  ProductRepo {
    private  static  String URL = "jdbc:mysql://localhost:3306/NCG_JAVA";
    private  static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private  static String USER = "root";
    private  static String PWD = "Welcome123";

    static  {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getProducts() {
        Connection con = null;
        List<Product> products = new ArrayList<>();
        String SQL = "SELECT id, name, price FROM products";
        try {
            con = DriverManager.getConnection(URL, USER, PWD);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
             if( con != null) {
                 try {
                     con.close();
                 } catch (SQLException e) {
                    e.printStackTrace();
                 }
             }
        }

        return products;
    }

    @Override
    public void addProduct(Product product) throws PersitenceException {
        Connection con = null;
        String SQL = "INSERT INTO product(id, name, price) VALUES (0, ?, ?)";
        try {
            con = DriverManager.getConnection(URL, USER, PWD);
            PreparedStatement statement = con.prepareStatement(SQL);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.executeUpdate(); // INSERT, DELETE or UPDATE
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new PersitenceException("unable to add product " + product.getId() + " already exists!!", ex);
            } else if (ex.getErrorCode() == 1054) {
                throw new PersitenceException("unable to add product, Bad Input !!!", ex);
            }
            else{
            throw new PersitenceException("unable to add product " + product + " !!!", ex);
        }
    }
        finally {
            if( con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Product getProduct(int id) {
        // Complete this using PreparedStatement
        // passing id which is present should return Product
        // else throw FetchException with message
        // Product with id 45 doesn't exist!!!
        return null;
    }
}
