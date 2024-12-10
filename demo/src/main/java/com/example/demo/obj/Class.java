package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String classID;
    private String className;

    public Class() {

    }

    public Class(String classID, String className) {
        this.classID = classID;
        this.className = className;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassID() {
        return classID;
    }

    public String getClassName() {
        return className;
    }
}
