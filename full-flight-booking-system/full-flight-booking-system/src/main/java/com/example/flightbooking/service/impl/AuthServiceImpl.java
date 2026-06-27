package com.example.flightbooking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.flightbooking.entity.User;
import com.example.flightbooking.repository.UserRepository;
import com.example.flightbooking.service.AuthService;
import com.example.flightbooking.service.EmailService;
import com.example.flightbooking.service.OTPService;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthServiceImpl
        implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OTPService otpService;

    @Autowired
    private EmailService emailService;

    private BCryptPasswordEncoder
            passwordEncoder =
            new BCryptPasswordEncoder();

    /*
     * =========================
     * SIGNUP
     * =========================
     */

    @Override
    public String signup(
            User user,
            HttpSession session) {

        Optional<User> existingUser =
                userRepository.findByEmail(
                        user.getEmail());

        if (existingUser.isPresent()) {

            return "Email already registered";
        }

        int otp =
                otpService.generateOtp();

        user.setPassword(

                passwordEncoder.encode(
                        user.getPassword()));

        user.setRole("ROLE_USER");

        user.setVerified(false);

        /*
         * SAVE TEMP SESSION
         */

        session.setAttribute(
                "tempUser",
                user);

        session.setAttribute(
                "otp",
                otp);

        /*
         * SEND OTP MAIL
         */

        try {

            emailService.sendOtpEmail(
                    user.getEmail(),
                    otp);

        } catch (Exception e) {

            return "Unable to send OTP mail";
        }

        return "SUCCESS";
    }

    /*
     * =========================
     * VERIFY OTP
     * =========================
     */

    @Override
    public String verifyOtp(
            int enteredOtp,
            HttpSession session) {

        Integer sessionOtp =
                (Integer) session.getAttribute(
                        "otp");

        User tempUser =
                (User) session.getAttribute(
                        "tempUser");

        if (sessionOtp == null
                || tempUser == null) {

            return "Session expired";
        }

        if (enteredOtp != sessionOtp) {

            return "Invalid OTP";
        }

        tempUser.setVerified(true);

        userRepository.save(tempUser);

        session.removeAttribute("otp");

        session.removeAttribute("tempUser");

        return "SUCCESS";
    }

    /*
     * =========================
     * LOGIN
     * =========================
     */

    @Override
    public String login(

            String email,

            String password,

            HttpSession session) {

        Optional<User> optionalUser =
                userRepository.findByEmail(
                        email);

        if (optionalUser.isEmpty()) {

            return "INVALID_EMAIL";
        }

        User user = optionalUser.get();

        /*
         * VERIFIED CHECK
         */

        if (!user.isVerified()) {

            return "NOT_VERIFIED";
        }

        /*
         * PASSWORD CHECK
         */

        if (!passwordEncoder.matches(
                password,
                user.getPassword())) {

            return "INVALID_PASSWORD";
        }

        /*
         * SAVE LOGIN SESSION
         */

        session.setAttribute(
                "loggedInUser",
                user);

        return user.getRole();
    }

    /*
     * =========================
     * LOGOUT
     * =========================
     */

    @Override
    public void logout(
            HttpSession session) {

        session.invalidate();
    }
}