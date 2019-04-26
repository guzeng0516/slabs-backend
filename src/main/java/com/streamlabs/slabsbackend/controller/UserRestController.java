package com.streamlabs.slabsbackend.controller;

import com.streamlabs.slabsbackend.model.User;
import com.streamlabs.slabsbackend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> findAll()  {
        return userService.findAll();
    }
}
