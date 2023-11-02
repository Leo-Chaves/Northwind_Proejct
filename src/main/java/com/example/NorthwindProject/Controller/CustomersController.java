package com.example.NorthwindProject.Controller;

import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Model.ServiceResponse;
import com.example.NorthwindProject.Service.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
@Controller
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

    @GetMapping("/save")
    public String save() {
        return "cadastro-cliente";
    }

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView save(@RequestParam("customerID")String customerID,
                       @RequestParam("companyName") String companyName,
                       @RequestParam("contactName") String contactName,
                       @RequestParam("contactTitle") String contactTitle,
                       @RequestParam("address") String address,
                       @RequestParam("city") String city,
                       @RequestParam("region") String region,
                       @RequestParam("postalCode") String postalCode,
                       @RequestParam("country") String country,
                       @RequestParam("phone") String phone,
                       @RequestParam("fax") String fax){

        Customer customer = new Customer();
        customer.setCustomerID(customerID);
        customer.setCompanyName(companyName);
        customer.setContactName(contactName);
        customer.setContactTitle(contactTitle);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setRegion(region);
        customer.setPostalCode(postalCode);
        customer.setCountry(country);
        customer.setPhone(phone);
        customer.setFax(fax);

        int result = iCustomersService.Save(customer);
        if(result == 1){
            System.out.println("Item Salvo");
        }

        return new ModelAndView("redirect:/api/Customers/list");
    }

    @GetMapping("/update")
    public String update() {
        return "atualizar-cliente";
    }

    @PostMapping("/update")
    public ModelAndView update(@RequestParam("customerID") String customerId,
                                                  @RequestParam("companyName") String companyName,
                                                  @RequestParam("contactName") String contactName,
                                                  @RequestParam("contactTitle") String contactTitle,
                                                  @RequestParam("address") String address,
                                                  @RequestParam("city") String city,
                                                  @RequestParam("region") String region,
                                                  @RequestParam("postalCode") String postalCode,
                                                  @RequestParam("country") String country,
                                                  @RequestParam("phone") String phone,
                                                  @RequestParam("fax") String fax){
        int result = iCustomersService.update(customerId, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
        if(result == 1){
            System.out.println("Item Atualizado");
        }

        return new ModelAndView("redirect:/api/Customers/list");
    }


    @GetMapping("/delete")
    public String delete() {
        return "deletar-cliente";
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("customerID") String id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCustomersService.Delete(id);
        if(result == 1){
            System.out.println("Item Deletado");
        }

        return new ModelAndView("redirect:/api/Customers/list");
    }
}
