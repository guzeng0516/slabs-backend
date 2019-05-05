package com.streamlabs.slabsbackend.model;

import java.util.List;

public class FollowEventResponse {
    private List<FollowEvent> data;

    public List<FollowEvent> getData() {
        return data;
    }

    public void setData(List<FollowEvent> data) {
        this.data = data;
    }
}
