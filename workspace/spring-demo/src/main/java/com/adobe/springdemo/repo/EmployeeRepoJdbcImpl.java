package com.adobe.springdemo.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public class EmployeeRepoJdbcImpl implements EmployeeRepo{
    @Override
    public void addEmployee() {
        System.out.println("Stored in database!!!");
    }
}
