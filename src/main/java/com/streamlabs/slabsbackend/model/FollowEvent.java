package com.streamlabs.slabsbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "follow_event")
public class FollowEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "from_id")
    private int fromID;

    @Column(name = "from_name")
    private String fromName;

    @Column(name = "to_id")
    private int toID;

    @Column(name = "to_name")
    private String toName;

    @Column(name = "followed_at")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
