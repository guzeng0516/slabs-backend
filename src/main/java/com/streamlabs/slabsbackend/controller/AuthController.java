package com.streamlabs.slabsbackend.controller;

import com.streamlabs.slabsbackend.model.Customer;
import com.streamlabs.slabsbackend.model.auth.TwitchLoginRequest;
import com.streamlabs.slabsbackend.service.AuthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @CrossOrigin
    @PostMapping(value = "/auth/twitch")
    public Customer twitchLogin(@RequestBody TwitchLoginRequest loginRequest) {
        return authService.loginWithTwitchIdToken(loginRequest.getIdToken());
    }
}
