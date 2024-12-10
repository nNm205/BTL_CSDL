package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String departmentName;
    private String departmentID;

    public Department() {

    }

    public Department(String departmentName, String departmentID) {
        this.departmentName = departmentName;
        this.departmentID = departmentID;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentID() {
        return departmentID;
    }
}
