package com.adobe.vehiclerental.client;

import com.adobe.vehiclerental.entity.Booking;
import com.adobe.vehiclerental.entity.Customer;
import com.adobe.vehiclerental.entity.Vehicle;
import com.adobe.vehiclerental.service.RentalService;
import com.adobe.vehiclerental.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookingClient implements CommandLineRunner {
    private  final RentalService service;
    private final DateUtil dateUtil;

    @Override
    public void run(String... args) throws Exception {
//        bookVehicle();
        returnVehicle();
    }

    private void returnVehicle() {
        System.out.println(service.returnBookedVehicle(1, dateUtil.fromString("21-08-2025")));
    }

    private void bookVehicle() {
//        Booking booking = Booking.builder().
//                customer(Customer.builder().email("anne@adobe.com").build())
//                        .vehicle(Vehicle.builder().registrationNumber("KA-05-AB-1234").build())
//                        .dateFrom(dateUtil.fromString("19-08-2025")).
//                build();
        Booking booking = Booking.builder().
                customer(Customer.builder().email("roger@adobe.com").build())
                .vehicle(Vehicle.builder().registrationNumber("DH-10-AA-0434").build())
                .dateFrom(dateUtil.fromString("20-08-2025")).
                build();
        System.out.println(service.doBooking(booking));
    }
}
