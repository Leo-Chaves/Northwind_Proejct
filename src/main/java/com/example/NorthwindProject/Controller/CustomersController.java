package com.example.NorthwindProject.Controller;

import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/Customers")
public class CustomersController {
    @Autowired
    private ICustomersService iCustomersService;

    @GetMapping("/list")
    public ModelAndView list() {
        List<Customer> customers = iCustomersService.findAll();

        ModelAndView modelAndView = new ModelAndView("Customers"); // O nome da página HTML
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

}
