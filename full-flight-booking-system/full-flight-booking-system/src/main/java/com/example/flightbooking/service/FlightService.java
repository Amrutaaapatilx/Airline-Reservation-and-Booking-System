package com.example.flightbooking.service;

import java.util.List;

import com.example.flightbooking.entity.Flight;

public interface FlightService {

    Flight addFlight(
            Flight flight);

    Flight updateFlight(
            Flight flight);

    void deleteFlight(
            Long id);

    Flight getFlightById(
            Long id);

    List<Flight> getAllFlights();

    List<Flight> searchFlights(
            String source,
            String destination);
}