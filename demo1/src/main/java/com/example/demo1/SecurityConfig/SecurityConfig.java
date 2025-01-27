package com.example.demo1.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Çaktivizo CSRF për endpoint-et
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/ordersInfo/**").permitAll() // Lejo akses të lirë për këtë endpoint
                        .anyRequest().authenticated() // Kërko autentikim për të gjitha endpoint-et e tjera
                );
        return http.build();
    }
}