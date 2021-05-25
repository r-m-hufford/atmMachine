package com.bank.atmapi.services;

import com.bank.atmapi.models.Customer;
import com.bank.atmapi.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer add(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> all() {
        return repo.findAll();
    }

    public Customer findById(Long id) {
        return repo.findById(id).get();
    }


    public Customer update(Customer c, Long id) {
        Customer customer = findById(id);

        customer.setFirst_name(c.getFirst_name());
        customer.setLast_name(c.getLast_name());
        customer.setEmail(c.getEmail());

        return repo.save(customer);
    }

    public Boolean delete(Long id) {
        repo.delete(findById(id));
        return true;
    }
}
