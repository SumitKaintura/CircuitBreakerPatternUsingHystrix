package com.niit.MongoDbExample.controller;

import com.niit.MongoDbExample.models.Customer;
import com.niit.MongoDbExample.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/v2")
public class MyController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
    {
        Customer save = this.customerRepository.save(customer);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCustomer()
    {
        return ResponseEntity.ok(customerRepository.findAll());
    }

    @PutMapping("/addMovie/{id}")
    public ResponseEntity<?> addMovie(@RequestBody Customer customer)
    {
        Customer save=this.customerRepository.save(customer);
        return ResponseEntity.ok(save);
    }

}
