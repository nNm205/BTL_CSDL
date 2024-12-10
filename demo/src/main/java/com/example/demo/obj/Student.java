package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentID;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "email")
    private String email;

    public Student() {

    }

    public Student(long studentID, String studentName,
                   String dateOfBirth, String email) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

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

    public long getStudentID() {
        return studentID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
