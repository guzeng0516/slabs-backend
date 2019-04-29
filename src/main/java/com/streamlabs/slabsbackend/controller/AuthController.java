package com.streamlabs.slabsbackend.controller;

import com.streamlabs.slabsbackend.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping(value = "/auth/twitch")
    public RedirectView twitchLogin(
            @RequestParam(name = "code") String code
    ) {
        authService.loginWithTwitchCode(code);
        return new RedirectView("/setting");
    }
}
