package com.example.flightbooking.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.flightbooking.service.OTPService;

@Service
public class OTPServiceImpl implements OTPService {

    @Override
    public int generateOtp() {

        Random random = new Random();

        return 100000 + random.nextInt(900000);
    }

    @Override
    public boolean verifyOtp(
            int generatedOtp,
            int enteredOtp) {

        return generatedOtp == enteredOtp;
    }
}