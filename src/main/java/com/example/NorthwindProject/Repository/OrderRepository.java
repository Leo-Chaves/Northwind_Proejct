package com.example.NorthwindProject.Repository;
import com.example.NorthwindProject.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrderRepository  implements  IOrderRepository{

    @Autowired
    private JdbcTemplate jdbcTemplete;
    @Override
    public List<Order> findAllOrders() {
        String SQL = "EXEC GetAllOrders";
        return  jdbcTemplete.query(SQL, BeanPropertyRowMapper.newInstance(Order.class));
    }
}
