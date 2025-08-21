package com.adobe.springdemo.service;

import com.adobe.springdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@Service
public class AppService {
    @Autowired
    DataSource dataSource;

    @Autowired
    @Qualifier("employeeRepoJdbcImpl")
    private EmployeeRepo employeeRepo; // implementation class is wired, loosely coupled

    public void doTask() {
        try {
            employeeRepo.addEmployee();
            Connection con = dataSource.getConnection(); // get connection from pool
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("select * from products");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
