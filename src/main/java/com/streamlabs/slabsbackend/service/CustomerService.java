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

    public Customer findOrCreateByTwitchIdToken(String code) {
        Optional<Customer> customerOptional = customerRepository.findByTwitchIdToken(code);
        return customerOptional.orElseGet(() -> createByTwitchIdToken(code));
    }

    private Customer createByTwitchIdToken(String code) {
        Customer customer = new Customer();
        customer.setFirstName("default first name");
        customer.setTwitchIdToken(code);
        return customerRepository.save(customer);
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void setStreamerName(Customer customer, String playerName) {
        customer.setStreamerName(playerName);
        // listen stream events here
        customerRepository.save(customer);
    }
}
