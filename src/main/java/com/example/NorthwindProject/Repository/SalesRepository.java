package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.SalesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesRepository implements ISalesRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SalesInfo> SalesMonth(int employeeID, int year, int month) {
        String sql = "EXEC GetVendasPorMes ?, ?, ?";
        return jdbcTemplate.query(sql, new Object[]{employeeID, year, month}, (rs, rowNum) -> {
            SalesInfo salesInfo = new SalesInfo();
            salesInfo.setEmployeeID(employeeID);
            salesInfo.setSalesCount(rs.getInt("SalesCount"));
            salesInfo.setCustomerName(rs.getString("ContactName"));
            return salesInfo;
        });
    }
}
