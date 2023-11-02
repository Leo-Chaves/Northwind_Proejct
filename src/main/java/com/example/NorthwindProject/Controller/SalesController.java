package com.example.NorthwindProject.Controller;

import com.example.NorthwindProject.Model.SalesInfo;
import com.example.NorthwindProject.Repository.ISalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/Sales")
public class SalesController {

    @Autowired
    ISalesRepository iSalesRepository;
    List<SalesInfo> sales;

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("sales");
        modelAndView.addObject("salesInfoList", sales);
        return modelAndView;
    }

    @GetMapping("/save")
    public String home() {
        return "salesInfo";
    }

    @PostMapping("/save")
    public ModelAndView saveSalesInfo(@RequestParam("employeeID") int employeeID,
                                      @RequestParam("year") int year,
                                      @RequestParam("month") int month) {

        sales = iSalesRepository.SalesMonth(employeeID, year, month);
        System.out.println(sales);

        return new ModelAndView("redirect:/api/Sales/list");
    }
}
