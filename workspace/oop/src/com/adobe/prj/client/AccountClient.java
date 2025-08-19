package com.adobe.prj.client;

import com.adobe.prj.entity.Account;

public class AccountClient {
    public static void main(String[] args) {
        System.out.println("Count :" + Account.getCount()); // 0
        Account first = new Account(); // default
        System.out.println("Count :" + Account.getCount()); // 1
        Account swethaAcc = new Account(5000); // parametrized
        System.out.println("Count :" + Account.getCount()); // 2

       // System.out.println(first.getCount()); // 1 avoid
       //  System.out.println(swethaAcc.getCount()); // 200 --> misleading avoid
        first.deposit(5600.00); // behaviour

        System.out.println("first account " + first.getBalance());
        System.out.println("Swetha account " + swethaAcc.getBalance());
    }
}
