// In the 'demo' service (Service1)
package com.example.microservice1.controller;

import com.example.microservice1.model.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    // Simple hardcoded data, simulating a database or service response
    @GetMapping("/users/{id}")
    public user getUser(@PathVariable Long id) {
        // Return a dummy user with the given ID
        return new user(id, "John Doe", "john.doe@example.com");
    }
}
