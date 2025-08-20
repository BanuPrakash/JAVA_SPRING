package com.adobe.prj.web;

import com.adobe.prj.dao.PersitenceException;
import com.adobe.prj.dao.ProductRepo;
import com.adobe.prj.dao.ProductRepoJdbcImpl;
import com.adobe.prj.entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    // GET http://localhost:8080/products
    // req and resp are injected; created by servlet container
    // req contains data from client
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter(); // opens character stream to client / Browser
        out.print("<html><body>");
        out.print("<h1>Product List </h1>");
        out.print("<table border=\"1\">");
        out.print("<tr><th>ID</th><th>Name</th><th>Price</th></tr>");
        ProductRepo productRepo = new ProductRepoJdbcImpl(); // use factory
        List<Product> products = productRepo.getProducts();
        for(Product p  : products) {
            out.print("<tr>");
                out.print("<td>" + p.getId()  +"</td>");
                out.print("<td>" + p.getName()  +"</td>");
                out.print("<td>" + p.getPrice()  +"</td>");
            out.print("</tr>");
        }
        out.print("</body></html>");
    }

    // POST http://localhost:8080/products
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Product product = new Product();
       product.setName(req.getParameter("name"));
       product.setPrice(Integer.parseInt(req.getParameter("price")));
       ProductRepo productRepo = new ProductRepoJdbcImpl();
        try {
            productRepo.addProduct(product);
//            System.out.println("Product added!!!");
            resp.sendRedirect("index.jsp?msg=Product added!!!");
        } catch (PersitenceException e) {
            //    System.out.println(e.getMessage()); // end user
               e.printStackTrace(); // developer
            resp.sendRedirect("index.jsp?msg=" + e.getMessage());
        }
    }
}
