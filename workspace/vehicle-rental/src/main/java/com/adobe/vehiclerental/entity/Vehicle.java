package com.adobe.vehiclerental.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name="vehicles")
public class Vehicle {
    @Id
    @Column(name="REG_NO", length = 25)
    private String registrationNumber;

    @Column(name="HIRE_RATE")
    private double dailyHireRate;

    @Column(name="FUEL_TYPE")
    private String fuelType;
}
