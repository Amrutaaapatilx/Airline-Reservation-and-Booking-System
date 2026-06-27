package com.example.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightbooking.entity.Flight;

@Repository
public interface FlightRepository
        extends JpaRepository<Flight, Long> {

    List<Flight> findBySourceAndDestination(
            String source,
            String destination);

    List<Flight> findBySource(String source);

    List<Flight> findByDestination(String destination);
}