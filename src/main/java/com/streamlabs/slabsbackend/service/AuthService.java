package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.dto.TwitchResponseDTO;
import com.streamlabs.slabsbackend.model.Customer;
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
        String url = "https://id.twitch.tv/oauth2/token" +
                "?client_id=jwlk0gk3rf4zy6fmhj8vps89b645kz" +
                "&client_secret=drguesuym0qtlcm4h1arnwdiqd92t2" +
                "&code=" + code +
                "&grant_type=authorization_code" +
                "&redirect_uri=http://localhost:8080/auth/twitch";
        TwitchResponseDTO twitchResponseDTO = restTemplate.postForObject(
                url,
                null,
                TwitchResponseDTO.class
        );
        return loginWithTwitchIdToken(twitchResponseDTO.getIdToken());
    }

    public Customer loginWithTwitchIdToken(String twitchIdToken) {
        return customerService.findOrCreateByTwitchIdToken(twitchIdToken);
    }
}
