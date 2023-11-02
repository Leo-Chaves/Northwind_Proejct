package com.example.NorthwindProject.Service;

import com.example.NorthwindProject.Model.SalesInfo;

import java.util.List;

public interface ISalesService {
    public List<SalesInfo> SalesMonth(int employeeID, int year, int month);
}
