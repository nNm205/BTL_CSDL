package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "admin-home-page";
    }

    @GetMapping("/log-in")
    public String loginPage() {
        return "log-in";
    }

    @GetMapping("/sign-up")
    public String signupPage() {
        return "sign-up";
    }

    @GetMapping("/change-password")
    public String changePasswordPage() {
        return "change-password";
    }

    @PostMapping("/log-in")
    public String login() {
        return "admin-home-page";
    }
}
