package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private CustomerService customerService;

    public AuthService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer loginWithTwitchIdToken(String twitchIdToken) {
        return customerService.findOrCreateByTwitchIdToken(twitchIdToken);
    }
}
