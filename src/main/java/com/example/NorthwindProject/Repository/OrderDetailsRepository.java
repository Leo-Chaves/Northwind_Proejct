package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailsRepository  implements  IOrderDetails{

    @Autowired
    private JdbcTemplate jdbcTemplete;

    @Override
    public int Save(OrderDetails orderDetails) {
        String SQL = "INSERT INTO [Order Details] (OrderID, ProductID, Quantity, UnitPrice, Discount) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplete.update(SQL, orderDetails.getOrderID(), orderDetails.getProductID(), orderDetails.getQuantity(), orderDetails.getUnitPrice(), orderDetails.getDiscount());
    }
}
