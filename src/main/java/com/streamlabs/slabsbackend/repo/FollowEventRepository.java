package com.streamlabs.slabsbackend.repo;

import com.streamlabs.slabsbackend.model.Customer;
import com.streamlabs.slabsbackend.model.FollowEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowEventRepository extends JpaRepository<FollowEvent, Integer> {
}
