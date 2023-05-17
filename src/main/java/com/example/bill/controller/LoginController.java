package com.example.bill.controller;


import com.example.bill.entity.User;
import com.example.bill.repository.UserRepository;
import com.example.bill.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        return "profile";
    }
}
