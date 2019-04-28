package com.streamlabs.slabsbackend.repo;

import com.streamlabs.slabsbackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    Optional<Customer> findByTwitchCode(String code);
}
