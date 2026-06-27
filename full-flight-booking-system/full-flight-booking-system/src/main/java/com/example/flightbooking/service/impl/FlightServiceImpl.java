package com.example.flightbooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbooking.entity.Flight;
import com.example.flightbooking.repository.FlightRepository;
import com.example.flightbooking.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {

        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) {

        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {

        flightRepository.deleteById(id);
    }

    @Override
    public Flight getFlightById(Long id) {

        return flightRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<Flight> getAllFlights() {

        return flightRepository.findAll();
    }

    @Override
    public List<Flight> searchFlights(

            String source,

            String destination) {

        List<Flight> flights =
                flightRepository.findAll();

        /*
         * FILTER FLIGHTS
         */

        if (source != null
                && destination != null
                && !source.isBlank()
                && !destination.isBlank()) {

            flights = flights.stream()

                    .filter(flight ->

                            flight.getSource()
                                    .equalsIgnoreCase(source)

                            &&

                            flight.getDestination()
                                    .equalsIgnoreCase(destination))

                    .toList();
        }

        return flights;
    }
}