package com.example.flightbooking.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * Relationships
     */

    @ManyToOne
    private User user;

    @ManyToOne
    private Flight flight;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Passenger> passengers;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    /*
     * Booking Details
     */

    private int passengerCount;

    private double totalAmount;

    private LocalDateTime bookingDate;

    private String bookingStatus;

    /*
     * Getters and Setters
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(
            List<Passenger> passengers) {

        this.passengers = passengers;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(
            int passengerCount) {

        this.passengerCount = passengerCount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
            double totalAmount) {

        this.totalAmount = totalAmount;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(
            LocalDateTime bookingDate) {

        this.bookingDate = bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(
            String bookingStatus) {

        this.bookingStatus = bookingStatus;
    }
}