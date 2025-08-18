package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountClient {
    public static void main(String[] args) {
        Account first = new Account(); // default
        Account second = new Account(5000); // parametrized

        first.deposit(5600.00);

        System.out.println("first account " + first.getBalance());
        System.out.println("second account " + second.getBalance());
    }
}
