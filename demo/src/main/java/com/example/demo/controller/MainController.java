package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/home-page")
    public String homePage() {
        return "home-page";
    }

    @GetMapping("/")
    public String loginPage() {
        return "log-in";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "sign-up";
    }

    @GetMapping("/change-password")
    public String changePasswordPage() {
        return "change-password";
    }

    /*
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String role,
                        Model model) {
        if (role.equals("admin")) {
            if (username.equals("admin") && password.equals("nnm210905")) {
                return "home-page";
            } else {
                model.addAttribute("error", "Username hoặc Password không đúng. Vui lòng thử lại!!!");
            }
        } else if (role.equals("user")) {
            if (username.equals("user") && password.equals("user123@")) {
                return "home-page";
            } else {
                model.addAttribute("error", "Username hoặc Password không đúng. Vui lòng thử lại!!!");
            }
        }
        return "log-in";
    }
     */
}
