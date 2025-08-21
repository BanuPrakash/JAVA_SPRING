package com.adobe.vehiclerental.repo;

import com.adobe.vehiclerental.entity.Booking;
import com.adobe.vehiclerental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT * FROM vehicles v WHERE v.reg_no NOT IN " +
            "(SELECT b.vehicle_fk FROM bookings b " +
            " WHERE :dt BETWEEN b.date_from AND b.date_to)", nativeQuery = true)
    List<Vehicle> getAvailableVehicles(@Param("dt") Date date);
}
