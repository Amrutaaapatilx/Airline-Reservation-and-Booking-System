package com.example.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.flightbooking.entity.Passenger;
import com.example.flightbooking.service.PassengerService;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    /*
     * =========================================
     * ADD PASSENGER PAGE
     * =========================================
     */

    @GetMapping("/add")
    public String addPassengerPage(
            Model model) {

        model.addAttribute(
                "passenger",
                new Passenger());

        return "user/add-passenger";
    }

    /*
     * =========================================
     * SAVE PASSENGER
     * =========================================
     */

    @PostMapping("/save")
    public String savePassenger(

            @ModelAttribute Passenger passenger,

            Model model) {

        passengerService.savePassenger(
                passenger);

        model.addAttribute(
                "success",
                "Passenger added successfully");

        return "redirect:/flights";
    }

    /*
     * =========================================
     * VIEW ALL PASSENGERS
     * =========================================
     */

    @GetMapping("/all")
    public String allPassengers(
            Model model) {

        model.addAttribute(

                "passengers",

                passengerService.getAllPassengers());

        return "user/passengers";
    }

    /*
     * =========================================
     * EDIT PASSENGER PAGE
     * =========================================
     */

    @GetMapping("/edit/{id}")
    public String editPassengerPage(

            @PathVariable Long id,

            Model model) {

        model.addAttribute(

                "passenger",

                passengerService.getPassengerById(
                        id));

        return "user/edit-passenger";
    }

    /*
     * =========================================
     * UPDATE PASSENGER
     * =========================================
     */

    @PostMapping("/update")
    public String updatePassenger(

            @ModelAttribute Passenger passenger) {

        passengerService.updatePassenger(
                passenger);

        return "redirect:/passenger/all";
    }

    /*
     * =========================================
     * DELETE PASSENGER
     * =========================================
     */

    @GetMapping("/delete/{id}")
    public String deletePassenger(

            @PathVariable Long id) {

        passengerService.deletePassenger(
                id);

        return "redirect:/passenger/all";
    }
}