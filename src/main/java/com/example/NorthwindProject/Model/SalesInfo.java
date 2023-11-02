package com.example.NorthwindProject.Model;

public class SalesInfo {
    private int employeeID;
    private int salesCount;
    private String customerName;

    public SalesInfo() {
    }

    public SalesInfo(int employeeID, int salesCount, String customerName) {
        this.employeeID = employeeID;
        this.salesCount = salesCount;
        this.customerName = customerName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}