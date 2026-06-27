package com.example.flightbooking.service;

import java.util.List;

import com.example.flightbooking.entity.Passenger;

public interface PassengerService {

    Passenger savePassenger(
            Passenger passenger);

    Passenger updatePassenger(
            Passenger passenger);

    Passenger getPassengerById(
            Long id);

    List<Passenger> getAllPassengers();

    void deletePassenger(
            Long id);
}