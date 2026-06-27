package com.example.flightbooking.service;

import java.util.List;

import com.example.flightbooking.entity.Booking;
import com.example.flightbooking.entity.User;

public interface BookingService {

    double calculatePayment(
            Long flightId,
            int passengerCount);

    Booking confirmBooking(

            Long flightId,

            int passengerCount,

            List<String> passengerNames,

            List<Integer> passengerAges,

            List<String> passengerGenders,

            User user);

    Booking getBookingById(
            Long bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByUserId(
            Long userId);

    void cancelBooking(
            Long bookingId);
}