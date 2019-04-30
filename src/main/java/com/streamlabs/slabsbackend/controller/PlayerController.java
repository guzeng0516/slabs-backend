package com.streamlabs.slabsbackend.controller;

import com.streamlabs.slabsbackend.model.Customer;
import com.streamlabs.slabsbackend.service.AuthService;
import com.streamlabs.slabsbackend.service.CustomerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
    private CustomerService customerService;
    private AuthService authService;

    public PlayerController(
            CustomerService customerService,
            AuthService authService
    ) {
        this.customerService = customerService;
        this.authService = authService;
    }

    @GetMapping("/")
    public String home(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/setting")
    public String setting() {
        return "setting";
    }

    @GetMapping("/player")
    public String player(
            @RequestParam(name = "player-name") String playerName,
            Model model
    ) {
        authService.getTwitchClientAccessToken();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Customer) {
            Integer id = ((Customer) principal).getId();
            Customer customer = customerService.findById(id);
            customerService.setStreamerName(customer, playerName);
        }
        model.addAttribute("playerName", playerName);
        return "player";
    }
}
