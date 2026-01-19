package com.github.gustavodscruz.vota_logo.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final UserAuthenticationFilter userAuthenticationFilter;

    public static final String[] NOT_REQUIRED_AUTHENTICATION_ENDPOINTS = {
        "/users/login",
        "/users"
    };

    public static final String[] REQUIRED_AUTHENTICATION_ENDPOINTS = {
        "/users/test"
    };

    public static final String [] COMMON_ENDPOINTS = {
        "/voting/public-results/*"
    };

    public static final String [] ADMIN_ENDPOINTS = {
        "/voting/admin/*"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
         return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(request -> request
                    .requestMatchers(NOT_REQUIRED_AUTHENTICATION_ENDPOINTS).permitAll()
                    .requestMatchers(REQUIRED_AUTHENTICATION_ENDPOINTS).authenticated()
                    .requestMatchers(ADMIN_ENDPOINTS).hasRole("ADMIN")
                    .requestMatchers(COMMON_ENDPOINTS).hasRole("COMMON")
                    .anyRequest().denyAll()
                )
                .addFilterBefore(userAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
