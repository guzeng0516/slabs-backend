package com.streamlabs.slabsbackend.webhook;

import com.streamlabs.slabsbackend.model.FollowEvent;
import com.streamlabs.slabsbackend.model.FollowEventResponse;
import com.streamlabs.slabsbackend.service.FollowEventService;
import com.streamlabs.slabsbackend.service.PusherService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TwitchWebhookController {
    private PusherService pusherService;
    private FollowEventService followEventService;

    public TwitchWebhookController(
            FollowEventService followEventService,
            PusherService pusherService
    ) {
        this.followEventService = followEventService;
        this.pusherService = pusherService;
    }

    @GetMapping(value = "/webhook/twitch/follow-events")
    public String followEventWebhookGet(
            @RequestParam("hub.challenge") String hubChallenge
    ) {
        System.out.println("returning change");
        return hubChallenge;
    }

    @PostMapping(value = "/webhook/twitch/follow-events")
    public void followEventWebhook(
            @RequestBody() FollowEventResponse request
    ) {
        System.out.println("webhook triggered");
        FollowEvent tmpFollowEvent = request.getData().get(0);

        FollowEvent followEvent = followEventService.save(tmpFollowEvent);
        pusherService.PushFollowEvent(followEvent);
    }
}
