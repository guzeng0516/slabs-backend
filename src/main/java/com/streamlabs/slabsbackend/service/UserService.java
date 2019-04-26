package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.model.User;
import com.streamlabs.slabsbackend.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
