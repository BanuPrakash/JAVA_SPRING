package com.adobe.vehiclerental.service;

import com.adobe.vehiclerental.entity.Customer;
import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.repo.CustomerRepo;
import com.adobe.vehiclerental.repo.VehicleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final VehicleRepo vehicleRepo; // constructor wiring instead of @Autowired [setter]
    private final CustomerRepo customerRepo;

    public long getVehicleCount() {
        return vehicleRepo.count();
    }
    public long getCustomerCount() {
        return customerRepo.count();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public Customer addCustomer(Customer customer) {
        return  customerRepo.save(customer);
    }

    public List<Vehicle> getVehicles() {
        // select * from vehicles
        return  vehicleRepo.findAll();
    }

    public List<Customer> getCustomers() {
        // select * from customers
        return  customerRepo.findAll();
    }

    public Vehicle getByRegNo(String reg) {
        Optional<Vehicle> opt = vehicleRepo.findById(reg);
        if(opt.isPresent()) {
            return opt.get();
        } else {
            return null; // modify to exception later
        }
    }
}
