package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

public class StudentDto {
    @NotEmpty(message = "The student id is required")
    private String studentID;

    @NotEmpty(message = "The student name is required")
    private String studentName;

    private String dateOfBirth;

    private String email;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
