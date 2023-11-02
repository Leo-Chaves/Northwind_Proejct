package com.example.NorthwindProject.Service;

import com.example.NorthwindProject.Model.Order;
import com.example.NorthwindProject.Model.SalesInfo;
import com.example.NorthwindProject.Repository.ISalesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SalesService implements ISalesService {

    @Autowired
    ISalesRepository iSalesRepository;
    @Override
    public List<SalesInfo> SalesMonth(int employeeID, int year, int month) {
        List<SalesInfo> list;
        try{
            list = iSalesRepository.SalesMonth(employeeID,year,month);
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }
}
