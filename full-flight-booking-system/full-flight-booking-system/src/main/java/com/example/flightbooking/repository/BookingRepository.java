package com.example.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightbooking.entity.Booking;
import com.example.flightbooking.entity.User;

@Repository
public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);
}