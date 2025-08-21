package com.adobe.springdemo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoMongoImpl implements EmployeeRepo{
    @Override
    public void addEmployee() {
        System.out.println("Stored in MongoDB!!!");
    }
}
