package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "EXEC GetAllCustomers", nativeQuery = true)
    List<Customer> callGetAllCustomersProcedure();
}