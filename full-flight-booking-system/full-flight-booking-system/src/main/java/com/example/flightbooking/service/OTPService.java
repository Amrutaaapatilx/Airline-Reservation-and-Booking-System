package com.example.flightbooking.service;

public interface OTPService {

    int generateOtp();

    boolean verifyOtp(
            int generatedOtp,
            int enteredOtp);
}