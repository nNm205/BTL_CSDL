package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentID;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "email", nullable = false)
    private String email;

    @Version
    private Long version = 0L;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    public Long getStudentID() {
        return studentID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
