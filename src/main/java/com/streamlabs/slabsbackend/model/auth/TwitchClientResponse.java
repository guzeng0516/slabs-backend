package com.streamlabs.slabsbackend.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchClientResponse {
    private String accessToken;

    @JsonProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
