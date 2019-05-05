package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.model.FollowEvent;
import com.streamlabs.slabsbackend.repo.FollowEventRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowEventService {
    private FollowEventRepository followEventRepository;

    public FollowEventService(FollowEventRepository followEventRepository) {
        this.followEventRepository = followEventRepository;
    }

    public FollowEvent save(FollowEvent followEvent) {
        return followEventRepository.save(followEvent);
    }
}
