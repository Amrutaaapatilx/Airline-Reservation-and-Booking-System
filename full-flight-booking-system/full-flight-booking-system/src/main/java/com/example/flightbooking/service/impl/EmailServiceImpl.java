package com.example.flightbooking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.flightbooking.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendOtpEmail(
            String toEmail,
            int otp) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(toEmail);

        message.setSubject("OTP Verification");

        message.setText(
                "Your OTP is: " + otp);

        mailSender.send(message);
    }

    @Override
    public void sendBookingConfirmation(
            String toEmail,
            String msg) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setTo(toEmail);

        message.setSubject(
                "Booking Confirmation");

        message.setText(msg);

        mailSender.send(message);
    }
}