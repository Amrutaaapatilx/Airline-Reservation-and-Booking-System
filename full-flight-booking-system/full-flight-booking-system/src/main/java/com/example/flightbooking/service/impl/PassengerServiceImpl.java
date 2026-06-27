package com.example.flightbooking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbooking.entity.Passenger;
import com.example.flightbooking.repository.PassengerRepository;
import com.example.flightbooking.service.PassengerService;

@Service
public class PassengerServiceImpl
        implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    /*
     * =========================================
     * SAVE PASSENGER
     * =========================================
     */

    @Override
    public Passenger savePassenger(
            Passenger passenger) {

        return passengerRepository.save(
                passenger);
    }

    /*
     * =========================================
     * UPDATE PASSENGER
     * =========================================
     */

    @Override
    public Passenger updatePassenger(
            Passenger updatedPassenger) {

        Passenger passenger =
                passengerRepository.findById(
                        updatedPassenger.getId())
                        .orElse(null);

        if (passenger == null) {

            return null;
        }

        passenger.setName(
                updatedPassenger.getName());

        passenger.setAge(
                updatedPassenger.getAge());

        passenger.setGender(
                updatedPassenger.getGender());

        passenger.setSeatNumber(
                updatedPassenger.getSeatNumber());

        return passengerRepository.save(
                passenger);
    }

    /*
     * =========================================
     * GET PASSENGER BY ID
     * =========================================
     */

    @Override
    public Passenger getPassengerById(
            Long id) {

        return passengerRepository.findById(id)
                .orElse(null);
    }

    /*
     * =========================================
     * GET ALL PASSENGERS
     * =========================================
     */

    @Override
    public List<Passenger> getAllPassengers() {

        return passengerRepository.findAll();
    }

    /*
     * =========================================
     * DELETE PASSENGER
     * =========================================
     */

    @Override
    public void deletePassenger(
            Long id) {

        passengerRepository.deleteById(id);
    }
}