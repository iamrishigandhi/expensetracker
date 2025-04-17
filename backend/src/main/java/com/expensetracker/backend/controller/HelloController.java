package com.expensetracker.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class HelloController {

    // Public endpoint - no authentication
    @GetMapping("/public/hello")
    public String publicHello() {
        return "👋 Hello from a public endpoint!";
    }

    // Secure endpoint - requires JWT
    @GetMapping("/secure/hello")
    public String secureHello(Principal principal) {
        return "🔐 Hello " + principal.getName() + "! You’ve accessed a protected endpoint.";
    }
}
