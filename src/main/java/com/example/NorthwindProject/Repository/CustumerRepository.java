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
        String SQL = "INSERT INTO Customers (Address, City, Country, CompanyName, ContactName, Fax, ContactTitle, Region, PostalCode) VALUES (?,?,?,?,?,?,?,?,?)";
        return jdbcTemplete.update(SQL, customer.getAddress(), customer.getCity(), customer.getCountry(), customer.getCompanyName(), customer.getContactName(), customer.getFax(), customer.getContactTitle(), customer.getRegion(), customer.getPostalCode());
    }


    @Override
    public int update(Customer customer) {
        String SQL = "UPDATE Customers set ContactName = ? WHERE CustumerID = ?";
        return jdbcTemplete.update(SQL, new Object[] {customer.getCustomerID(),customer.getAddress(),customer.getCity(),customer.getCountry(), customer.getCompanyName(), customer.getContactName(), customer.getFax(), customer.getCompanyName(), customer.getContactTitle(), customer.getRegion(),customer.getPostalCode()});
    }

    @Override
    public int Delete(String customerId) {
        String SQL = "DELETE FROM Customers WHERE CustomerID = ?";
        return jdbcTemplete.update(SQL, customerId, customerId);
    }
}
