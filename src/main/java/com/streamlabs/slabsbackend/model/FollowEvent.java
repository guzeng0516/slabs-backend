package com.streamlabs.slabsbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowEvent {
    private int fromID;
    private String fromName;
    private int toID;
    private String toName;
    private String followedAt;

    @JsonProperty("from_id")
    public int getFromID() {
        return fromID;
    }

    public void setFromID(int fromID) {
        this.fromID = fromID;
    }

    @JsonProperty("from_name")
    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    @JsonProperty("to_id")
    public int getToID() {
        return toID;
    }

    public void setToID(int toID) {
        this.toID = toID;
    }

    @JsonProperty("to_name")
    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    @JsonProperty("followed_at")
    public String getFollowedAt() {
        return followedAt;
    }

    public void setFollowedAt(String followedAt) {
        this.followedAt = followedAt;
    }
}
