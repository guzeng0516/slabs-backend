package com.streamlabs.slabsbackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchResponseDTO {
    private String idToken;

    @JsonProperty("id_token")
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
