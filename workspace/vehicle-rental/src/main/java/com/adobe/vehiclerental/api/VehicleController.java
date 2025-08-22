package com.adobe.vehiclerental.api;


import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehicles")
@RequiredArgsConstructor
public class VehicleController  {
    private final RentalService service;

    // GET http://localhost:8080/api/vehicles
    @GetMapping()
    public List<Vehicle> getVehicles() {
        return service.getVehicles();
    }


    // POST http://localhost:8080/api/vehicles
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

}