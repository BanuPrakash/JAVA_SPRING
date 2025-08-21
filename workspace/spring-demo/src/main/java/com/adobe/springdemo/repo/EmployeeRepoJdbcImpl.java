package com.adobe.springdemo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoJdbcImpl implements EmployeeRepo{
    @Override
    public void addEmployee() {
        System.out.println("Stored in database!!!");
    }
}
