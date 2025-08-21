package com.adobe.springdemo.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("prod")
@Repository
public class EmployeeRepoMongoImpl implements EmployeeRepo{
    @Override
    public void addEmployee() {
        System.out.println("Stored in MongoDB!!!");
    }
}
