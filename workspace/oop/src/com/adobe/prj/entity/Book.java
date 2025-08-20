package com.adobe.prj.entity;

import com.adobe.prj.annotation.Column;
import com.adobe.prj.annotation.Table;

@Table(name = "books")
public class Book {
    private int id;
    private String name;

    public Book() {
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name="BOOK_ID", type = "NUMERIC(10)")
    public int getId() {
        return id;
    }

    @Column(name="TITLE")
    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
