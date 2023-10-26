package com.example.NorthwindProject.Model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class Order{
    private int OrderID;
    private String CustomerID;
    private int EmployeeID;
    private LocalDate OrderDate;
    private LocalDate RequiredDate;
    private LocalDate ShippedDate;
    private int ShipVia;
    private double Freight;
    private String ShipName;
    private String ShipAddress;
    private String ShipCity;
    private String ShipRegion;
    private String ShipPostalCode;
    private String ShipCountry;

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public LocalDate getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        OrderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return RequiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        RequiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return ShippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        ShippedDate = shippedDate;
    }

    public int getShipVia() {
        return ShipVia;
    }

    public void setShipVia(int shipVia) {
        ShipVia = shipVia;
    }

    public double getFreight() {
        return Freight;
    }

    public void setFreight(double freight) {
        Freight = freight;
    }

    public String getShipName() {
        return ShipName;
    }

    public void setShipName(String shipName) {
        ShipName = shipName;
    }

    public String getShipAddress() {
        return ShipAddress;
    }

    public void setShipAddress(String shipAddress) {
        ShipAddress = shipAddress;
    }

    public String getShipCity() {
        return ShipCity;
    }

    public void setShipCity(String shipCity) {
        ShipCity = shipCity;
    }

    public String getShipRegion() {
        return ShipRegion;
    }

    public void setShipRegion(String shipRegion) {
        ShipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return ShipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        ShipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return ShipCountry;
    }

    public void setShipCountry(String shipCountry) {
        ShipCountry = shipCountry;
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "OrderID=" + OrderID +
                ", CustomerID='" + CustomerID + '\'' +
                ", EmployeeID=" + EmployeeID +
                ", OrderDate=" + OrderDate +
                ", RequiredDate=" + RequiredDate +
                ", ShippedDate=" + ShippedDate +
                ", ShipVia=" + ShipVia +
                ", Freight=" + Freight +
                ", ShipName='" + ShipName + '\'' +
                ", ShipAddress='" + ShipAddress + '\'' +
                ", ShipCity='" + ShipCity + '\'' +
                ", ShipRegion='" + ShipRegion + '\'' +
                ", ShipPostalCode='" + ShipPostalCode + '\'' +
                ", ShipCountry='" + ShipCountry + '\'' +
                '}';
    }
}