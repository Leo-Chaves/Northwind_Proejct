package com.example.NorthwindProject.Service;

import com.example.NorthwindProject.Model.Order;

import java.util.List;

public interface IOrderService {

    public List<Order> findAllOrders();

    public int save(Order order);

}
