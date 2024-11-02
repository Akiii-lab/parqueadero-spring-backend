package com.parking.entities;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@Slf4j

@RequestMapping("/api/v1")
public class CusomerController {

    @Autowired
    private CustomerService customerService;

    //get all
    @GetMapping("/customers")
    public ResponseEntity<Object> getAll() {
        Map<String, Object> map = new HashMap< String, Object>();
        try {
            List<Customer> customers = customerService.findAll();
            return new ResponseEntity<Object>(customers, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);   
        }
    }

    //get by email
    @GetMapping("/customers/{email}")
    public ResponseEntity<Object> getByEmail(@PathVariable String email) {
        try {
            Customer customer = customerService.findByEmail(email);
            return new ResponseEntity<Object>(customer, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap< String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //get by email and password
    @GetMapping("/customers/{email}")
    public ResponseEntity<Object> getByEmailAndPassword(@PathVariable String email, String password) {
        try {
            Customer customer = customerService.findByEmailAndPassword(email, password);
            return new ResponseEntity<Object>(customer, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap< String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //save
    @PostMapping("/customers/save")
    public ResponseEntity<Object> save(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService.save(customer);
            return new ResponseEntity<Object>(savedCustomer, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, Object> map = new HashMap< String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //join
    @PostMapping("/customers/join")
    public ResponseEntity<Boolean> join(Customer customer) {
        try {
            if(customerService.join(customer)) {
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            }
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
