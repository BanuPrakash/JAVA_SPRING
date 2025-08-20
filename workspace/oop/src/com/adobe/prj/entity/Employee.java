package com.adobe.prj.entity;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

import java.util.Date;

@Table(name="EMP")
public class Employee {
    int empId;
    String name;
    Date hireDate;
    double salary;

    @Column(name = "EMP_ID", type = "int")
    public int getEmpId() {
        return empId;
    }

    @Column(name="EMP_NAME")
    public String getName() {
        return name;
    }

    @Column(name="HIRE_DATE", type="TIMESTAMP")
    public Date getHireDate() {
        return hireDate;
    }

    @Column(name="SAL", type = "double")
    public double getSalary() {
        return salary;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
