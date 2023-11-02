package com.example.NorthwindProject.Service;

import com.example.NorthwindProject.Model.OrderDetails;
import com.example.NorthwindProject.Repository.IOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdeDetailsService implements  IOrderDetailsSrevice{

    @Autowired
    private IOrderDetails iOrderDetails;

    @Override
    public int Save(OrderDetails orderDetails) {
        int row;
        try{
            row = iOrderDetails.Save(orderDetails);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
