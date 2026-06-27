package com.example.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.flightbooking.entity.Flight;
import com.example.flightbooking.service.BookingService;
import com.example.flightbooking.service.FlightService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingService bookingService;

    /*
     * =====================================
     * ADMIN DASHBOARD
     * =====================================
     */

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute(
                "flight",
                new Flight());

        model.addAttribute(
                "flights",
                flightService.getAllFlights());

        return "admin/dashboard";
    }

    /*
     * =====================================
     * ADD FLIGHT
     * =====================================
     */

    @PostMapping("/add-flight")
    public String addFlight(
            @ModelAttribute Flight flight) {

        flightService.addFlight(flight);

        return "redirect:/admin/dashboard";
    }

    /*
     * =====================================
     * EDIT FLIGHT PAGE
     * =====================================
     */

    @GetMapping("/edit-flight/{id}")
    public String editFlightPage(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "flight",
                flightService.getFlightById(id));

        return "admin/edit-flight";
    }

    /*
     * =====================================
     * UPDATE FLIGHT
     * =====================================
     */

    @PostMapping("/update-flight")
    public String updateFlight(
            @ModelAttribute Flight flight) {

        flightService.updateFlight(flight);

        return "redirect:/admin/dashboard";
    }

    /*
     * =====================================
     * DELETE FLIGHT
     * =====================================
     */

    @GetMapping("/delete-flight/{id}")
    public String deleteFlight(
            @PathVariable Long id) {

        flightService.deleteFlight(id);

        return "redirect:/admin/dashboard";
    }

    /*
     * =====================================
     * VIEW BOOKINGS
     * =====================================
     */

    @GetMapping("/bookings")
    public String viewBookings(
            Model model) {

        model.addAttribute(
                "bookings",
                bookingService.getAllBookings());

        return "admin/bookings";
    }
}