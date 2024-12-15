package com.example.demo.obj;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "students", uniqueConstraints = {
        @UniqueConstraint(columnNames = "student_id"),
        @UniqueConstraint(columnNames = "email")
})
public class Student {
    @Id
    @Column(name = "student_id")
    private Long studentID;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "email", nullable = false)
    private String email;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getStudentID() {
        return studentID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
