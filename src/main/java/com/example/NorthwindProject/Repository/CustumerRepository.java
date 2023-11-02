package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustumerRepository implements ICustumersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplete;

    @Override
    public List<Customer> findAll() {
        String SQL = "EXEC GetAllCustomers";
        return  jdbcTemplete.query(SQL, BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public int Save(Customer customer) {
        String SQL = "INSERT INTO Customers (CustomerID, Address, City, Country, CompanyName, ContactName, Fax, ContactTitle, Region, PostalCode, Phone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplete.update(SQL, customer.getCustomerID(), customer.getAddress(), customer.getCity(), customer.getCountry(), customer.getCompanyName(), customer.getContactName(), customer.getFax(), customer.getContactTitle(), customer.getRegion(), customer.getPostalCode(), customer.getPhone());
    }


    @Override
    public int update(String customerId, String companyName, String contactName, String contactTitle, String address, String city, String region, String postalCode, String country, String phone, String fax) {
        String SQL = "UPDATE Customers SET CompanyName = ?, ContactName = ?, ContactTitle = ?, Address = ?, City = ?, Region = ?, PostalCode = ?, Country = ?, Phone = ?, Fax = ? WHERE CustomerID = ?";
        return jdbcTemplete.update(SQL, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, customerId);
    }

    @Override
    public int Delete(String customerId) {
        String SQL = "DELETE FROM Customers WHERE CustomerID = ?";
        return jdbcTemplete.update(SQL, customerId);
    }
}
