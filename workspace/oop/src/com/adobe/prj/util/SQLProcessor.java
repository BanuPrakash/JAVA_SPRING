package com.adobe.prj.util;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

import java.lang.reflect.Method;

public class SQLProcessor {
    // Book.class, Employee.class,..
    // ? makes it as read only, won't allow mutation
    public static String createStatement(Class<?> clazz) {
        StringBuilder builder = new StringBuilder();
        Table table = clazz.getAnnotation(Table.class);
        if( table != null) {
            builder.append("create table ");
            builder.append(table.name());
            builder.append(" ("); // create table books (

            Method[] methods = clazz.getDeclaredMethods();
            for(Method m : methods) {
                if(m.getName().startsWith("get")) {
                    Column column = m.getAnnotation(Column.class);
                    if( column != null) {
                        builder.append(column.name());
                        builder.append(" ");
                        builder.append(column.type());
                        builder.append(", ");// create table books( BOOK_ID NUMERIC(10),
                    }
                }
            }
            builder.setCharAt(builder.lastIndexOf(","), ')');
        }
        return builder.toString();
    }

    // Book b = new Book(52, "Head First");
    // insert into books values (52, 'Head First');
    public static String insertStatement(Object obj) {
        StringBuilder builder = new StringBuilder();
            // try it as task
        // createStatement code +
         // note m.invoke() reflection api
        return builder.toString();
    }

}
