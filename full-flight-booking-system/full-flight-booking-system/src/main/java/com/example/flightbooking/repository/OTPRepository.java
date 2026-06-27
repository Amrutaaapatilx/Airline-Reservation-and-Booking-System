package com.example.flightbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.flightbooking.entity.OTP;

@Repository
public interface OTPRepository
        extends JpaRepository<OTP, Long> {

    Optional<OTP> findByEmail(String email);
}