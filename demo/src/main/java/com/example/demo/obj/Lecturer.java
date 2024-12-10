package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lecturerID;
    private String username;
    private String password;
    private String email;
    private String lecturerName;
    private String dateOfBirth;

    public Lecturer() {

    }

    public Lecturer(int lecturerID, String username, String password,
                    String email, String lecturerName,
                    String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.lecturerName = lecturerName;
        this.lecturerID = lecturerID;
        this.dateOfBirth = dateOfBirth;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public void setLecturerID(int lecturerID) {
        this.lecturerID = lecturerID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public int getLecturerID() {
        return lecturerID;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
