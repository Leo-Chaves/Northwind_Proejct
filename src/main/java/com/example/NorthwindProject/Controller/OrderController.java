package com.example.NorthwindProject.Controller;


import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Model.Order;
import com.example.NorthwindProject.Service.ICustomersService;
import com.example.NorthwindProject.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService iorderService;

    @PostMapping("/list")
    public ResponseEntity<List<Order>> list(){
        var result = iorderService.findAllOrders();
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
