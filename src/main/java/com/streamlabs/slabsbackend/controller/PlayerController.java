package com.streamlabs.slabsbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
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
        model.addAttribute("playerName", playerName);
        return "player";
    }
}
