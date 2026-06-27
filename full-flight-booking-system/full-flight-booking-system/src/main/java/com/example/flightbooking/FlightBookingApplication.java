package com.example.flightbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.flightbooking.entity.User;
import com.example.flightbooking.repository.UserRepository;

@SpringBootApplication
public class FlightBookingApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                FlightBookingApplication.class,
                args);
    }

    /*
     * =========================================
     * DEFAULT ADMIN CREATION
     * =========================================
     */

    @Bean
    CommandLineRunner createAdmin(
            UserRepository userRepository,
            BCryptPasswordEncoder passwordEncoder) {

        return args -> {

            /*
             * CHECK ADMIN EXISTS
             */

            if (userRepository
                    .findByEmail("admin@gmail.com")
                    .isEmpty()) {

                User admin = new User();

                admin.setName("Admin");

                admin.setEmail("admin@gmail.com");

                admin.setPassword(
                        passwordEncoder.encode(
                                "admin123"));

                admin.setRole("ROLE_ADMIN");

                admin.setVerified(true);

                userRepository.save(admin);

                System.out.println(
                        "Default Admin Created");
            }
        };
    }
}