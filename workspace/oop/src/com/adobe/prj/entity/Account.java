package com.adobe.prj.entity;

public class Account {
    private double balance; // state of object, instance variable, object member
    private static int count; // class member, state of class
    // default constructor
    public Account() {
        count++;
    }
    // parametrized constructor
    public Account(double balance) {
        this.balance = balance;
        count++;
    }

    // instance methods
    public void deposit(double amt) {
        this.balance += amt;
    }
    // instance methods
    public double getBalance() {
        return  this.balance;
    }

    // class method
    public static int getCount() {
        return  count;
    }
}
