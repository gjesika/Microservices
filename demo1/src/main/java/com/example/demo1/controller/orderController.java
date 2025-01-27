package com.example.demo1.controller;
import com.example.demo1.model.order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class orderController {

    private final String userServiceUrl = "http://localhost:8081/users/"; // URL i shërbimit të përdoruesve

    // Get an order by orderId and user info
    @GetMapping("/orders/{id}")
    public order getOrder(@PathVariable Long id) {
        // Simulimi i një porosie të hardkoduar
        order order = new order(id, 1L, "Laptop", 1200.00);

        // Komunikimi me shërbimin e përdoruesve për të marrë informacion mbi përdoruesin
        RestTemplate restTemplate = new RestTemplate();
        String userUrl = userServiceUrl + order.getUserId();
        String userInfo = restTemplate.getForObject(userUrl, String.class);

        // Shtimi i informacionit të përdoruesit përkatës në log
        System.out.println("User Info for Order " + order.getOrderId() + ": " + userInfo);

        return order;
    }


    @GetMapping("/ordersInfo/{id}")
public String getUserInfo(@PathVariable Long id){
    order order1 = new order(id, 1L, "Laptop", 1200.00);
    RestTemplate restTemplate = new RestTemplate();
    String userUrl = userServiceUrl + order1.getUserId();
    String userInfo = restTemplate.getForObject(userUrl, String.class);
    return "User Info for Order " + userInfo;
}
}