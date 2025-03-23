package com.sokratis.SpringSecJWTDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to Spring Secure Web App with JWT "+request.getSession().getId();
    }
}
