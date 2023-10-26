package com.example.NorthwindProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {

    @GetMapping ("/showAll")
    public String showAll(){
       return "showAll";
    }
}
