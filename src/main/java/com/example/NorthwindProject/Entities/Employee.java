package com.example.NorthwindProject.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    private int employeeID;
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Date birthDate;
    private Date hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private byte[] photo;
    private String notes;
    private int reportsTo;
    private String photoPath;
}
