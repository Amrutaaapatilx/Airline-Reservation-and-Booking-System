package com.example.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightbooking.entity.Passenger;

@Repository
public interface PassengerRepository
        extends JpaRepository<Passenger, Long> {

}