package com.example.demo1.controller;

import com.example.demo1.Dto.OrderDetailsDTO;
import com.example.demo1.model.order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class orderController {

    @Autowired
    private WebClient.Builder webClientBuilder; // Injektimi i WebClient.Builder

    private final String userServiceUrl = "http://localhost:8081/users/"; // URL i shërbimit të përdoruesve

    // Endpoint për të marrë informacion rreth porosisë dhe përdoruesit përkatës
    @GetMapping("/ordersClient/{id}")
    public OrderDetailsDTO getOrderClient(@PathVariable Long id) throws JsonProcessingException {
        // Simulimi i një porosie të hardkoduar
        order order = new order(id, 1L, "Laptop", 1200.00);

        // Përdorim WebClient për të marrë informacion nga shërbimi i përdoruesve
        String userInfo = webClientBuilder
                .baseUrl(userServiceUrl) // Vendos adresën e bazës për shërbimin 'users'
                .build()
                .get()
                .uri("/{userId}", order.getUserId()) // Lidhja me users-service
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Blokim për të marrë përgjigjen sinkron

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            userInfo = objectMapper.writeValueAsString(userInfo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new OrderDetailsDTO(order, userInfo); // Kthimi i informacionit të porosisë dhe përdoruesit
    }

    // Endpoint për të marrë një porosi me id dhe informacionin e përdoruesit
    @GetMapping("/orders/{id}")
    public order getOrder(@PathVariable Long id) {
        // Simulimi i një porosie të hardkoduar
        order order = new order(id, 1L, "Laptop", 1200.00);

        // Komunikimi me shërbimin e përdoruesve për të marrë informacion mbi përdoruesin
        String userUrl = userServiceUrl + order.getUserId();
        String userInfo = new RestTemplate().getForObject(userUrl, String.class);

        // Shtimi i informacionit të përdoruesit përkatës në log
        System.out.println("User Info for Order " + order.getOrderId() + ": " + userInfo);

        return order;
    }

    // Endpoint për të marrë informacionin e përdoruesit për një porosi
    @GetMapping("/ordersInfo/{id}")
    public String getUserInfo(@PathVariable Long id){
        order order1 = new order(id, 1L, "Laptop", 1200.00);
        String userUrl = userServiceUrl + order1.getUserId();
        String userInfo = new RestTemplate().getForObject(userUrl, String.class);
        return "User Info for Order " + userInfo; // Kthimi i informacionit të përdoruesit
    }
}
