package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.model.Customer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private CustomerService customerService;

    public AuthService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer loginWithTwitchIdToken(String twitchIdToken) {
        Customer customer = customerService.findOrCreateByTwitchIdToken(twitchIdToken);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                customer,
                null,
                customer.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        return customer;
    }
}
