package com.example.demo.Dto;

import com.example.demo.obj.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class StudentDto {
    @NotEmpty(message = "student id field is required")
    private String studentID;

    @NotEmpty(message = "student name field is required")
    private String studentName;

    @NotEmpty(message = "gender field is required")
    private String gender;

    @NotEmpty(message = "address field is required")
    private String address;

    @NotEmpty(message = "phone number field is required")
    private String phoneNumber;

    @NotNull(message = "date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotEmpty(message = "email field is required")
    private String email;

    @NotEmpty(message = "gpa field is required")
    private String gpa;

    @NotEmpty(message = "major field is required")
    private String major;

    @NotEmpty(message = "course field is required")
    private String course;

    private String username;
    private String password;

    public StudentDto() {

    }

    public StudentDto(Student student) {
        this.studentID = String.valueOf(student.getStudentID());
        this.studentName = student.getStudentName();
        this.gender = student.getGender();
        this.address = student.getAddress();
        this.phoneNumber = student.getPhoneNumber();
        this.dateOfBirth = student.getDateOfBirth();
        this.email = student.getEmail();
        this.major = student.getMajor();
        this.course = student.getCourse();
        this.gpa = String.valueOf(student.getGpa());
        this.username = String.valueOf(student.getStudentID());
        this.password = String.valueOf(student.getStudentID());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String toString() {
        return studentID + " " + studentName + " " + gender + " " + dateOfBirth + " " + address + " " + phoneNumber + " " + email + " " + gpa + " " + major + " " + course;
    }
}
