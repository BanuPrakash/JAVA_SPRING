package com.adobe.prj.entity;

public class Account {
    private double balance; // state, instance variable
    // default constructor
    public Account() {
    }
    // parametrized constructor
    public Account(double balance) {
        this.balance = balance;
    }

    // instance methods
    public void deposit(double amt) {
        this.balance += amt;
    }
    // instance methods
    public double getBalance() {
        return  this.balance;
    }
}
