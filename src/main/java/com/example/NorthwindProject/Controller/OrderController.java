package com.example.NorthwindProject.Controller;


import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Model.Order;
import com.example.NorthwindProject.Service.ICustomersService;
import com.example.NorthwindProject.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("api/Orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService iorderService;

    @GetMapping("/list")
    public ModelAndView list(){
        List<Order> orders = iorderService.findAllOrders();

        ModelAndView modelAndView = new ModelAndView("Orders");
        modelAndView.addObject("orders", orders);

        return modelAndView;

    }
}
