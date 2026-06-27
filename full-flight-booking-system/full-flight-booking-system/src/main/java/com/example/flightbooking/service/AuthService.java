package com.example.flightbooking.service;

import com.example.flightbooking.entity.User;

import jakarta.servlet.http.HttpSession;

public interface AuthService {

    String signup(
            User user,
            HttpSession session);

    String verifyOtp(
            int enteredOtp,
            HttpSession session);

    String login(
            String email,
            String password,
            HttpSession session);

    void logout(
            HttpSession session);
}