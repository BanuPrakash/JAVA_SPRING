package com.adobe.vehiclerental.repo;

import com.adobe.vehiclerental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data JPA will generate @Repository class
public interface VehicleRepo extends JpaRepository<Vehicle, String> {
}
