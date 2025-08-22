package com.adobe.ecomapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="customers")
public class Customer {

    @Id
    private String email;

    @Column(name="FNAME")
    private String firstName;

    @Column(name="LNAME")
    private String lastName;

//    @OneToMany
//    @JoinColumn(name="customer_fk")
//    List<Order> orders;

}
