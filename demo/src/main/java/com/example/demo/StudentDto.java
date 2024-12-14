package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

public class StudentDto {
    @NotEmpty(message = "The student id is required")
    private String studentID;

    @NotEmpty(message = "The student name is required")
    private String studentName;

    @NotEmpty(message = "The date of birth is required")
    private String dateOfBirth;

    @NotEmpty(message = "The email is required")
    private String email;

    public String getEmail() {
        return email;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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
