package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Model.Order;
import com.example.NorthwindProject.Model.OrderDetails;

public interface IOrderDetails {
    public int Save(OrderDetails orderDetails);
}
