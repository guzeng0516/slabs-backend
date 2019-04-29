package com.streamlabs.slabsbackend.model.auth;

public class TwitchLoginRequest {
    private String idToken;

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
