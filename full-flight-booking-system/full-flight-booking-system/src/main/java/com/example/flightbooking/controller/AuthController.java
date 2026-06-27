package com.example.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.flightbooking.entity.User;
import com.example.flightbooking.repository.UserRepository;
import com.example.flightbooking.service.AuthService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private UserRepository userRepository;

    /*
     * =========================
     * LOGIN PAGE
     * =========================
     */

    @GetMapping("/")
    public String loginPage() {

        return "auth/login";
    }

    /*
     * =========================
     * SIGNUP PAGE
     * =========================
     */

    @GetMapping("/signup")
    public String signupPage(
            Model model) {

        model.addAttribute(
                "user",
                new User());

        return "auth/signup";
    }

    /*
     * =========================
     * USER SIGNUP
     * =========================
     */

    @PostMapping("/signup")
    public String signup(
            @ModelAttribute User user,
            HttpSession session,
            Model model) {

        String result =
                authService.signup(
                        user,
                        session);

        if (!result.equals("SUCCESS")) {

            model.addAttribute(
                    "error",
                    result);

            return "auth/signup";
        }

        model.addAttribute(
                "email",
                user.getEmail());

        return "auth/verify-otp";
    }

    /*
     * =========================
     * OTP PAGE
     * =========================
     */

    @GetMapping("/verify-otp")
    public String otpPage() {

        return "auth/verify-otp";
    }

    /*
     * =========================
     * VERIFY OTP
     * =========================
     */

    @PostMapping("/verify-otp")
    public String verifyOtp(
            @RequestParam(name = "otp") Integer enteredOtp,
            HttpSession session,
            Model model) {

        Integer sessionOtp =
                (Integer) session.getAttribute("otp");

        User tempUser =
                (User) session.getAttribute("tempUser");

        if (sessionOtp == null || tempUser == null) {

            model.addAttribute("error",
                    "Session expired");

            return "auth/login";
        }

        if (enteredOtp.equals(sessionOtp)) {

            tempUser.setVerified(true);

            userRepository.save(tempUser);

            session.removeAttribute("otp");

            session.removeAttribute("tempUser");

            model.addAttribute("success",
                    "Account verified successfully");

            return "auth/login";
        }

        model.addAttribute("error",
                "Invalid OTP");

        return "auth/verify-otp";
    }

    /*
     * =========================
     * LOGIN
     * =========================
     */

    @PostMapping("/login")
    public String login(

            @RequestParam String username,

            @RequestParam String password,

            HttpSession session,

            Model model) {

        String result =
                authService.login(
                        username,
                        password,
                        session);

        if (result.equals("INVALID_EMAIL")
                || result.equals("INVALID_PASSWORD")
                || result.equals("NOT_VERIFIED")) {

            model.addAttribute(
                    "error",
                    result.replace("_", " "));

            return "auth/login";
        }

        if (result.equals("ROLE_ADMIN")) {

            return "redirect:/admin/dashboard";
        }

        return "redirect:/flights";
    }

    /*
     * =========================
     * LOGOUT
     * =========================
     */

    @GetMapping("/logout")
    public String logout(
            HttpSession session) {

        authService.logout(session);

        return "redirect:/";
    }
}