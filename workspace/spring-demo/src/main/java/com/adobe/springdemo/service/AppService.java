package com.adobe.springdemo.service;

import com.adobe.springdemo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    @Qualifier("employeeRepoJdbcImpl")
    private EmployeeRepo employeeRepo; // implementation class is wired, loosely coupled

    public void doTask() {
        employeeRepo.addEmployee();
    }
}
