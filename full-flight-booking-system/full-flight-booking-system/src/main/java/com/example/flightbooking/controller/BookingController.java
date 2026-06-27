package com.example.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.flightbooking.entity.Booking;
import com.example.flightbooking.entity.Flight;
import com.example.flightbooking.entity.User;
import com.example.flightbooking.service.BookingService;
import com.example.flightbooking.service.FlightService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingService bookingService;

    /*
     * =========================================
     * BOOKING PAGE
     * =========================================
     */

    @GetMapping("/{flightId}")
    public String bookingPage(
            @PathVariable Long flightId,
            Model model) {
    	
    	 Flight flight =
    	            flightService.getFlightById(flightId);

    	 model.addAttribute("flight", flight);

        return "user/booking";
    }

    /*
     * =========================================
     * PAYMENT CALCULATION
     * =========================================
     */

    @PostMapping("/calculate-payment")
    public String calculatePayment(

            @RequestParam("flightId") Long flightId,

            @RequestParam("passengerCount") int passengerCount,

            Model model) {
    	
    	 Flight flight =
    	            flightService.getFlightById(flightId);

        double totalAmount =
                bookingService.calculatePayment(
                        flightId,
                        passengerCount);

        model.addAttribute("flight", flight);


        model.addAttribute(
                "passengerCount",
                passengerCount);

        model.addAttribute(
                "totalAmount",
                totalAmount);

        return "user/payment";
    }

    /*
     * =========================================
     * CONFIRM BOOKING
     * =========================================
     */

    @PostMapping("/confirm-booking")
    public String confirmBooking(

            @RequestParam("flightId")
            Long flightId,

            @RequestParam("passengerCount")
            int passengerCount,

            @RequestParam("passengerNames")
            List<String> passengerNames,

            @RequestParam("passengerAges")
            List<Integer> passengerAges,

            @RequestParam("passengerGenders")
            List<String> passengerGenders,

            HttpSession session,

            Model model) {

        User user =
        (User) session.getAttribute(
                "loggedInUser");

        if (user == null) {

            return "redirect:/";
        }

        Booking booking =
                bookingService.confirmBooking(

                        flightId,

                        passengerCount,

                        passengerNames,

                        passengerAges,

                        passengerGenders,

                        user);

        if (booking == null) {

            model.addAttribute(
                    "error",
                    "Booking failed");

            return "user/payment";
        }

        model.addAttribute(
                "booking",
                booking);

        return "user/ticket";
    }

    /*
     * =========================================
     * TICKET PAGE
     * =========================================
     */

    @GetMapping("/ticket/{bookingId}")
    public String generateTicket(

            @PathVariable Long bookingId,

            Model model) {

        model.addAttribute(
                "booking",
                bookingService.getBookingById(
                        bookingId));

        return "user/ticket";
    }

    /*
     * =========================================
     * BOOKING HISTORY
     * =========================================
     */

    @GetMapping("/history")
    public String bookingHistory(

            HttpSession session,

            Model model) {

        User user =
        (User) session.getAttribute(
                "loggedInUser");

        if (user == null) {

            return "redirect:/";
        }

        model.addAttribute(

                "bookings",

                bookingService.getBookingsByUserId(
                        user.getId()));

        return "user/booking-history";
    }

    /*
     * =========================================
     * CANCEL BOOKING
     * =========================================
     */

    @GetMapping("/cancel/{bookingId}")
    public String cancelBooking(

            @PathVariable Long bookingId,

            HttpSession session) {

        User user =
        (User) session.getAttribute(
                "loggedInUser");

        if (user == null) {

            return "redirect:/";
        }

        bookingService.cancelBooking(
                bookingId);

        return "redirect:/booking/history";
    }
}