package com.adobe.ecomapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="order_date")
    private Date orderDate = new Date(); // system date

    // order is by
    @ManyToOne
    @JoinColumn(name= "customer_fk")
    Customer customer;

    // order has many items
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_fk")
    Set<LineItem> items = new HashSet<>();

    private double total;
}
