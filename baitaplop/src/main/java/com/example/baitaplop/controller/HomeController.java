package com.example.baitaplop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(Model model) {

        model.addAttribute("message", "Hello from HomeController!");
        model.addAttribute("homeTitle", "Trang Home sử dụng Thymeleaf");

        return "index";
    }
}
