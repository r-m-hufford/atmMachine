package com.bank.atmapi.controllers;

import com.bank.atmapi.models.Customer;
import com.bank.atmapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("add")
    public ResponseEntity<Customer> add(@RequestParam Customer customer){
        return new ResponseEntity<Customer>(service.add(customer), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> all(){
        return ResponseEntity.ok(service.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> update(@RequestParam Customer customer, @PathVariable Long id){
        return new ResponseEntity<>(service.update(customer, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.NO_CONTENT);
    }

}
