package com.streamlabs.slabsbackend.service;

import com.streamlabs.slabsbackend.model.Customer;
import com.streamlabs.slabsbackend.repo.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findOrCreateByTwitchCode(String code) {
        Optional<Customer> customerOptional = customerRepository.findByTwitchCode(code);
        return customerOptional.orElseGet(() -> createByTwitchCode(code));
    }

    private Customer createByTwitchCode(String code) {
        Customer customer = new Customer();
        customer.setFirstname("default first name");
        customer.setTwitchCode(code);
        return customerRepository.save(customer);
    }
}
