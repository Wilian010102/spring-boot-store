package com.store.ecommerce.controllers;

import com.store.ecommerce.entities.User;
import com.store.ecommerce.repositories.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName(); // karena login berdasarkan email

        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            model.addAttribute("name", user.getName());
        } else {
            model.addAttribute("name", email);
        }

        model.addAttribute("sessionId", request.getSession().getId());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}