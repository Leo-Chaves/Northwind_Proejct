package com.example.NorthwindProject.Service;

import com.example.NorthwindProject.Model.Customer;
import com.example.NorthwindProject.Repository.ICustumersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustumersService implements ICustomersService{

    @Autowired
    private ICustumersRepository iCustumersRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> list;
        try{
            list = iCustumersRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int Save(Customer customer) {
       int row;
        try{
            row = iCustumersRepository.Save(customer);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update( String customerId, String companyName, String contactName, String contactTitle, String address, String city, String region, String postalCode, String country, String phone, String fax) {
        int row;
        try{
            row = iCustumersRepository.update(customerId, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int Delete(String customerId) {
        int row;
        try{
            row = iCustumersRepository.Delete(customerId);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
