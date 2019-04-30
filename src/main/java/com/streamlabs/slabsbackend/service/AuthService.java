package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.model.Customer;
import com.streamlabs.slabsbackend.model.auth.TwitchClientResponse;
import org.springframework.http.HttpEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private CustomerService customerService;

    public AuthService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String getTwitchClientAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        TwitchClientResponse response = restTemplate.postForObject(
                "https://id.twitch.tv/oauth2/token?" +
                        "client_id=jwlk0gk3rf4zy6fmhj8vps89b645kz" +
                        "&" +
                        "client_secret=slzi0veznbj565s5kthuvn1qngm270" +
                        "&" +
                        "grant_type=client_credentials" +
                        "&" +
                        "scope=channel_read", null, TwitchClientResponse.class);
        System.out.println(response.getAccessToken());
        return response.getAccessToken();


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
