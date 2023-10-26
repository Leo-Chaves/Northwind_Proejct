package com.example.NorthwindProject.Controller;

import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Custumers")
@CrossOrigin("*")
public class CustomersController {
    @Autowired
    private ICustomersService iCustomersService;

    @PostMapping("/list")
    public ResponseEntity<List<Customer>> list(){
        var result = iCustomersService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
