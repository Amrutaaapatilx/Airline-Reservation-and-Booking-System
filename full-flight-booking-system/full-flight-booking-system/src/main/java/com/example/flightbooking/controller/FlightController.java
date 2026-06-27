package com.example.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.flightbooking.service.FlightService;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    /*
     * =========================================
     * VIEW ALL FLIGHTS
     * =========================================
     */

    @GetMapping
    public String viewAllFlights(
            Model model) {

        model.addAttribute(
                "flights",
                flightService.getAllFlights());

        return "user/flights";
    }

    /*
     * =========================================
     * SEARCH FLIGHTS
     * =========================================
     */

    @GetMapping("/search")
    public String searchFlights(

            @RequestParam(required = false)
            String source,

            @RequestParam(required = false)
            String destination,

            Model model) {

        model.addAttribute(

                "flights",

                flightService.searchFlights(
                        source,
                        destination));

        return "user/flights";
    }

    /*
     * =========================================
     * FLIGHT DETAILS
     * =========================================
     */

    @GetMapping("/details/{id}")
    public String flightDetails(

            @PathVariable Long id,

            Model model) {

        model.addAttribute(

                "flight",

                flightService.getFlightById(id));

        return "user/flight-details";
    }
}