package com.example.NorthwindProject.Controller;


import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Model.Order;
import com.example.NorthwindProject.Model.OrderDetails;
import com.example.NorthwindProject.Repository.IOrderDetails;
import com.example.NorthwindProject.Service.ICustomersService;
import com.example.NorthwindProject.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("api/Orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService iorderService;

    @Autowired
    private IOrderDetails iOrderDetails;


    @GetMapping("/list")
    public ModelAndView list(){
        List<Order> orders = iorderService.findAllOrders();

        ModelAndView modelAndView = new ModelAndView("Orders");
        modelAndView.addObject("orders", orders);

        return modelAndView;
    }

    @GetMapping("/save")
    public String save() {
        return "fazer-pedido";
    }

    @PostMapping("/save")
    @ResponseBody
    public ModelAndView saveOrder(@RequestParam("productID") int productID,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("unitPrice") float unitPrice,
                                  @RequestParam("dicount") float discount,
                                  @RequestParam("customerID") String customerID,
                                  @RequestParam("employeeID") int employeeID,
                                  @RequestParam("orderDate") LocalDate orderDate,
                                  @RequestParam("requiredDate") LocalDate requiredDate,
                                  @RequestParam("shippedDate")  LocalDate shippedDate,
                                  @RequestParam("shipVia") int shipVia,
                                  @RequestParam("freight") double freight,
                                  @RequestParam("shipName") String shipName,
                                  @RequestParam("shipAddress") String shipAddress,
                                  @RequestParam("shipCity") String shipCity,
                                  @RequestParam("shipRegion") String shipRegion,
                                  @RequestParam("shipPostalCode") String shipPostalCode,
                                  @RequestParam("shipCountry") String shipCountry) {

        Order order = new Order();
        order.setCustomerID(customerID);
        order.setEmployeeID(employeeID);
        order.setOrderDate(orderDate);
        order.setRequiredDate(requiredDate);
        order.setShippedDate(shippedDate);
        order.setShipVia(shipVia);
        order.setFreight(freight);
        order.setShipName(shipName);
        order.setShipAddress(shipAddress);
        order.setShipCity(shipCity);
        order.setShipRegion(shipRegion);
        order.setShipPostalCode(shipPostalCode);
        order.setShipCountry(shipCountry);

        int orderId = iorderService.save(order);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setDiscount(discount);
        orderDetails.setOrderID(orderId);
        orderDetails.setUnitPrice(unitPrice);
        orderDetails.setQuantity(quantity);
        orderDetails.setProductID(productID);

       int result = iOrderDetails.Save(orderDetails);

        if (result == 1) {
            System.out.println("Pedido Salvo");
        }

        return new ModelAndView("redirect:/api/Orders/list");
    }

}
