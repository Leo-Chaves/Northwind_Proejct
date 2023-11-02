package com.example.NorthwindProject.Service;
import com.example.NorthwindProject.Model.Order;
import com.example.NorthwindProject.Repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Override
    public List<Order> findAllOrders() {
        List<Order> list;
        try{
            list = iOrderRepository.findAllOrders();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Order order) {
        int row;
        try{
            row = iOrderRepository.save(order);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
