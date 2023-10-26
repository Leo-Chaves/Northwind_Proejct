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
        return 0;
    }

    @Override
    public int update(Customer customer) {
        return 0;
    }

    @Override
    public int Delete(Customer customer) {
        return 0;
    }
}
