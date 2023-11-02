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


    @Override
    public int save(Order order) {
        String SQL = "INSERT INTO Orders (INSERT INTO Orders (CustomerID, EmployeeID, OrderDate, RequiredDate, ShippedDate, ShipVia, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int rowsAffected = jdbcTemplete.update(SQL, order.getCustomerID(), order.getEmployeeID(), order.getOrderDate(), order.getRequiredDate(), order.getShippedDate(), order.getShipVia(), order.getFreight(), order.getShipName(), order.getShipAddress(), order.getShipCity(), order.getShipRegion(), order.getShipPostalCode(), order.getShipCountry());

        if (rowsAffected > 0) {
            String queryLastID = "SELECT IDENT_CURRENT('Orders') as LastID";

            Integer lastInsertedID = jdbcTemplete.queryForObject(queryLastID, Integer.class);

            if (lastInsertedID != null) {
                System.out.println("pedido Inserido");
                return lastInsertedID;
            }
        }

        return -1;

    }
}
