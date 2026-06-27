package com.example.flightbooking.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightbooking.entity.Booking;
import com.example.flightbooking.entity.Flight;
import com.example.flightbooking.entity.Passenger;
import com.example.flightbooking.entity.Payment;
import com.example.flightbooking.entity.User;
import com.example.flightbooking.repository.BookingRepository;
import com.example.flightbooking.repository.FlightRepository;
import com.example.flightbooking.service.BookingService;

@Service
public class BookingServiceImpl
        implements BookingService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookingRepository bookingRepository;

    /*
     * =========================================
     * CALCULATE PAYMENT
     * =========================================
     */

    @Override
    public double calculatePayment(

            Long flightId,

            int passengerCount) {

        Flight flight =
                flightRepository.findById(
                        flightId)
                        .orElse(null);

        if (flight == null) {

            return 0;
        }

        return flight.getTicketPrice()
                * passengerCount;
    }

    /*
     * =========================================
     * CONFIRM BOOKING
     * =========================================
     */

    @Override
    public Booking confirmBooking(

            Long flightId,

            int passengerCount,

            List<String> passengerNames,

            List<Integer> passengerAges,

            List<String> passengerGenders,

            User user) {

        Flight flight =
                flightRepository.findById(
                        flightId)
                        .orElse(null);

        if (flight == null) {

            return null;
        }

        /*
         * CHECK SEAT AVAILABILITY
         */

        if (flight.getAvailableSeats()
                < passengerCount) {

            return null;
        }

        /*
         * CREATE BOOKING
         */

        Booking booking =
                new Booking();

        booking.setUser(user);

        booking.setFlight(flight);

        booking.setPassengerCount(
                passengerCount);

        booking.setBookingDate(
                LocalDateTime.now());

        booking.setBookingStatus(
                "CONFIRMED");

        /*
         * TOTAL AMOUNT
         */

        double totalAmount =
                flight.getTicketPrice()
                * passengerCount;

        booking.setTotalAmount(
                totalAmount);

        /*
         * PAYMENT
         */

        Payment payment =
                new Payment();

        payment.setAmount(
                totalAmount);

        payment.setPaymentMethod(
                "CARD");

        payment.setPaymentStatus(
                "SUCCESS");

        payment.setPaymentDate(
                LocalDateTime.now());

        booking.setPayment(payment);

        /*
         * PASSENGERS
         */

        List<Passenger> passengers =
                new ArrayList<>();

        int currentSeat =
                flight.getTotalSeats()
                - flight.getAvailableSeats() + 1;

        for (int i = 0;
             i < passengerCount;
             i++) {

            Passenger passenger =
                    new Passenger();

            passenger.setName(
                    passengerNames.get(i));

            passenger.setAge(
                    passengerAges.get(i));

            passenger.setGender(
                    passengerGenders.get(i));

            String seatNumber =
                    "A" + currentSeat++;

            passenger.setSeatNumber(
                    seatNumber);

            passengers.add(passenger);
        }

        booking.setPassengers(
                passengers);

        /*
         * UPDATE FLIGHT SEATS
         */

        flight.setAvailableSeats(

                flight.getAvailableSeats()
                - passengerCount);

        flightRepository.save(flight);

        /*
         * SAVE BOOKING
         */

        return bookingRepository.save(
                booking);
    }

    /*
     * =========================================
     * GET BOOKING BY ID
     * =========================================
     */

    @Override
    public Booking getBookingById(
            Long bookingId) {

        return bookingRepository.findById(
                bookingId)
                .orElse(null);
    }

    /*
     * =========================================
     * GET ALL BOOKINGS
     * =========================================
     */

    @Override
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();
    }

    /*
     * =========================================
     * USER BOOKING HISTORY
     * =========================================
     */

    @Override
    public List<Booking> getBookingsByUserId(
            Long userId) {

        return bookingRepository.findAll()

                .stream()

                .filter(booking ->
                        booking.getUser()
                                .getId()
                                .equals(userId))

                .toList();
    }

    /*
     * =========================================
     * CANCEL BOOKING
     * =========================================
     */

    @Override
    public void cancelBooking(
            Long bookingId) {

        Booking booking =
                bookingRepository.findById(
                        bookingId)
                        .orElse(null);

        if (booking == null) {

            return;
        }

        if ("CANCELLED".equals(
                booking.getBookingStatus())) {

            return;
        }

        Flight flight =
                booking.getFlight();

        flight.setAvailableSeats(

                flight.getAvailableSeats()
                + booking.getPassengerCount());

        flightRepository.save(flight);

        booking.setBookingStatus(
                "CANCELLED");

        if (booking.getPayment() != null) {

            booking.getPayment()
                    .setPaymentStatus(
                            "REFUNDED");
        }

        bookingRepository.save(booking);
    }
}