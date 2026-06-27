package com.example.flightbooking.service;

import java.util.List;

import com.example.flightbooking.entity.User;

public interface UserService {

    User saveUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void deleteUser(Long id);
}