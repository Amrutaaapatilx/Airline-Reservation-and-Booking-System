package com.example.flightbooking.service;

public interface EmailService {

    void sendOtpEmail(
            String toEmail,
            int otp);

    void sendBookingConfirmation(
            String toEmail,
            String message);
}