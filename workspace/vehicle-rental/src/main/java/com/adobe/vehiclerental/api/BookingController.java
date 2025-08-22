package com.adobe.vehiclerental.api;

import com.adobe.vehiclerental.entity.Booking;
import com.adobe.vehiclerental.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final RentalService service;

    // POST http://localhost:8080/api/bookings
    // Accept: text/plain
    // Content-type: application/json
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String bookVehicle(@RequestBody Booking booking) {
        service.doBooking(booking);
        return  "Vehicle Rental booked!!!";
    }

    @PatchMapping ("/{bookingId}")
    public String returnVehicle(@PathVariable("bookingId") int id,
                                @RequestParam(name="returnDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date returnDate) {
        return service.returnBookedVehicle(id, returnDate);
    }

    @GetMapping()
    public List<Booking> getBookings() {
        return  service.getBookings();
    }
}
