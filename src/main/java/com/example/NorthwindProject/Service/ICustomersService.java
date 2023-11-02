package com.example.NorthwindProject.Service;

import com.example.NorthwindProject.Model.Customer;

import java.util.List;

public interface ICustomersService {

    public List<Customer> findAll();

    public int Save(Customer customer);

    public int update(String customerId, String companyName, String contactName, String contactTitle, String address, String city, String region, String postalCode, String country, String phone, String fax);

    public int Delete(String customerId);


}
