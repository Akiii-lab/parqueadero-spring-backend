package com.parking.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //get all
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    //get by email
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    //get by email and password
    public Customer findByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    //save
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    //join
    public boolean join(Customer customer) {
        Customer tmp = customerRepository.findByEmail(customer.getEmail());
        if(tmp != null && tmp.getPassword().equals(customer.getPassword())) {
            return true;
        }
        return false;
    }
}
