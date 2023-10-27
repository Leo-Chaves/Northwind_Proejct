package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.Customer;

import java.util.List;

public interface ICustumersRepository {
    public List<Customer> findAll();

    public int Save(Customer customer);

    public int update(Customer customer);

    public int Delete(String customerId);



}
