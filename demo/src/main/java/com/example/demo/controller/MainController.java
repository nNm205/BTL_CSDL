package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
    @GetMapping("/")
    public String homePage() {
        return "main";
    }

    @GetMapping("/signin")
    public String loginPage() {
        return "signin";
    }

    @PostMapping("/signin")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Vui lòng điền đầy đủ tên đăng nhập và mật khẩu.");
            return "signin";
        }

        if ("admin".equals(username) && "admin".equals(password)) {
            return "main";
        } else {
            model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại!");
            return "signin";
        }
    }
}
