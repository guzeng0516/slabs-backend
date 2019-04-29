package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.dto.TwitchResponseDTO;
import com.streamlabs.slabsbackend.model.Customer;
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

    public Customer loginWithTwitchCode(String code) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://id.twitch.tv/oauth2/token?client_id=jwlk0gk3rf4zy6fmhj8vps89b645kz&client_secret=awsiet0w5z2n0b1l4pg84gjdprccn4&code=" + code + "&grant_type=authorization_code&redirect_uri=http://localhost:8080/auth/twitch";
//        TwitchResponseDTO twitchResponseDTO = restTemplate.postForObject(
//                url,
//                null,
//                TwitchResponseDTO.class
//        );
        return loginWithTwitchIdToken("abc");
    }

    public Customer loginWithTwitchIdToken(String twitchIdToken) {
        Customer customer = customerService.findOrCreateByTwitchIdToken(twitchIdToken);
        Authentication auth =
                new UsernamePasswordAuthenticationToken(customer, null, customer.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);
        return customer;
    }
}
