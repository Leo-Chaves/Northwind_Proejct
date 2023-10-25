package com.example.NorthwindProject.Controller;

import com.example.NorthwindProject.Entities.Customer;
import com.example.NorthwindProject.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.callGetAllCustomersProcedure();
    }
}