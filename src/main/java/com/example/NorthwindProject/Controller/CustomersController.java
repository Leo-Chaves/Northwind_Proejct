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
    public String home() {

        return "cadastro-cliente";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestParam("customerID")String customerID,
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

        return "redirect:/api/Customers/list";
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
