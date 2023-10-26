package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.Order;

import java.util.List;

public interface IOrderRepository {
    public List<Order> findAllOrders();

}
