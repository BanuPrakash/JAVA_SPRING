package com.adobe.prj.client;

import com.adobe.prj.entity.Book;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.util.SQLProcessor;

public class SQLClient {
    public static void main(String[] args) {
        String SQL = SQLProcessor.createStatement(Book.class);
        System.out.println(SQL);

        SQL = SQLProcessor.createStatement(Employee.class);
        System.out.println(SQL);
    }
}
