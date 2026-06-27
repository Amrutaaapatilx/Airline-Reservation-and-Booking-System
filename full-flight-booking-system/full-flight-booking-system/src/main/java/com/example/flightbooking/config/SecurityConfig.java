package com.example.flightbooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    /*
     * PASSWORD ENCODER
     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /*
     * SECURITY FILTER CHAIN
     */

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http

            /*
             * Disable CSRF
             */

            .csrf(csrf -> csrf.disable())

            /*
             * URL ACCESS
             */

            .authorizeHttpRequests(auth -> auth

                    .requestMatchers(
                            "/",
                            "/signup",
                            "/verify-otp",
                            "/login",
                            "/css/**",
                            "/js/**")
                    .permitAll()

                    .anyRequest()
                    .permitAll())

            /*
             * Disable default login form
             */

            .formLogin(form -> form.disable())

            /*
             * Logout
             */

            .logout(logout -> logout

                    .logoutUrl("/logout")

                    .logoutSuccessUrl("/"));

        return http.build();
    }
}