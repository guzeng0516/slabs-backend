package com.streamlabs.slabsbackend.webhook;

import com.pusher.rest.Pusher;
import com.streamlabs.slabsbackend.model.FollowEvent;
import com.streamlabs.slabsbackend.model.FollowEventResponse;
import com.streamlabs.slabsbackend.service.FollowEventService;
import com.streamlabs.slabsbackend.service.PusherService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    public void followEventWebhook(
            @RequestParam("hub.topic") String hubTopic
    ) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-ID", "jwlk0gk3rf4zy6fmhj8vps89b645kz");

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<FollowEventResponse> response = restTemplate.exchange(
                hubTopic,
                HttpMethod.GET,
                entity,
                FollowEventResponse.class
        );

        FollowEvent tmpFollowEvent = response.getBody().getData().get(0);

        FollowEvent followEvent = followEventService.save(tmpFollowEvent);
        pusherService.PushFollowEvent(followEvent);
    }

    public PusherService getPusherService() {
        return pusherService;
    }

    public void setPusherService(PusherService pusherService) {
        this.pusherService = pusherService;
    }
}
