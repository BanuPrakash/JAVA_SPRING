package com.adobe.vehiclerental.repo;

import com.adobe.vehiclerental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Integer> {
}
