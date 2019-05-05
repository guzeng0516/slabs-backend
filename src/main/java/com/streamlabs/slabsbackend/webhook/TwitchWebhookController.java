package com.streamlabs.slabsbackend.webhook;

import com.streamlabs.slabsbackend.model.FollowEvent;
import com.streamlabs.slabsbackend.model.FollowEventWebHookRequest;
import com.streamlabs.slabsbackend.service.FollowEventService;
import com.streamlabs.slabsbackend.service.PusherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TwitchWebhookController {
    private PusherService pusherService;
    private FollowEventService followEventService;

    public TwitchWebhookController(FollowEventService followEventService) {
        this.followEventService = followEventService;
    }

    @GetMapping(value = "/webhook/twitch/follow-events")
    public void twitchLogin(
            @RequestBody FollowEventWebHookRequest request
    ) {
        FollowEvent requestData = request.getData();
        FollowEvent followEvent = followEventService.save(requestData);
        pusherService.PushFollowEvent(requestData);
    }

    public PusherService getPusherService() {
        return pusherService;
    }

    public void setPusherService(PusherService pusherService) {
        this.pusherService = pusherService;
    }
}
