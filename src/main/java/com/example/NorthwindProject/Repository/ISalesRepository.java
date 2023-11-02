package com.example.NorthwindProject.Repository;

import com.example.NorthwindProject.Model.SalesInfo;

import java.util.List;

public interface ISalesRepository {
    public List<SalesInfo> SalesMonth(int employeeID, int year, int month);
}
