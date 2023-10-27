package com.example.NorthwindProject.Controller;

import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Model.ServiceResponse;
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

        ModelAndView modelAndView = new ModelAndView("Customers");
        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Customer customer){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCustomersService.Save(customer);
        if(result == 1){
            serviceResponse.setMessage("Item Salvo");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Customer customer){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCustomersService.update(customer);
        if(result == 1){
            serviceResponse.setMessage("Item Atualizado");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable String id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCustomersService.Delete(id);
        if(result == 1){
            serviceResponse.setMessage("Item Deletado");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
