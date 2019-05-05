package com.streamlabs.slabsbackend.webhook;

import com.streamlabs.slabsbackend.model.FollowEvent;
import com.streamlabs.slabsbackend.service.FollowEventService;
import com.streamlabs.slabsbackend.service.PusherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TwitchWebhookController {
    private PusherService pusherService;
    private FollowEventService followEventService;

    public TwitchWebhookController(FollowEventService followEventService) {
        this.followEventService = followEventService;
    }

    @GetMapping(value = "/webhook/twitch/follow-events")
    public void followEventWebhook(
            @RequestParam("hub.topic") String hubTopic
    ) {
        RestTemplate restTemplate = new RestTemplate();
        FollowEvent followEvent = restTemplate.getForObject(
                hubTopic,
                FollowEvent.class
        );
        followEventService.save(followEvent);
        pusherService.PushFollowEvent(followEvent);
    }

    public PusherService getPusherService() {
        return pusherService;
    }

    public void setPusherService(PusherService pusherService) {
        this.pusherService = pusherService;
    }
}
