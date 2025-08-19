package com.adobe.prj.entity;


public abstract class Product implements Comparable {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isExpensive() {
//        return  false;
//    }

    // pure virtual machine
    public abstract boolean isExpensive();

    // p1.compareTo(p2);
    // this --> p1
    // o --> p2
    @Override
    public int compareTo(Object o) {
        Product other = (Product) o;
        return (int)(this.price - other.price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
