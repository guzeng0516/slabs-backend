package com.streamlabs.slabsbackend.service;

import com.pusher.rest.Pusher;
import com.streamlabs.slabsbackend.model.FollowEvent;
import org.springframework.stereotype.Service;

@Service
public class PusherService {
    public void PushFollowEvent(FollowEvent followEvent) {
        Pusher pusher = new Pusher("772765", "5f25988ca7ae72cad432", "f69d7c8333f1db8ceccf");
        pusher.setCluster("mt1");

        pusher.trigger(
                "twitch-channel",
                "follow-event",
                followEvent
        );
    }
}
