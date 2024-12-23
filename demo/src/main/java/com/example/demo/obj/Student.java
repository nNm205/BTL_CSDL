package com.example.demo.obj;

import com.example.demo.Dto.StudentDto;
import jakarta.persistence.*;

import java.time.LocalDate;

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
    private LocalDate dateOfBirth;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "major", nullable = false)
    private String major;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "gpa", nullable = false)
    private double gpa;

    private String username;
    private String password;

    public Student() {}

    public Student(Long studentID, String studentName, LocalDate dateOfBirth,
                   String email, String gender, String phoneNumber,
                   String address, String major, String course, double gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.major = major;
        this.course = course;
        this.gpa = gpa;
        this.username = String.valueOf(studentID);
        this.password = String.valueOf(studentID);
    }

    public Student(Student otherStudent) {
        this.studentID = otherStudent.getStudentID();
        this.studentName = otherStudent.getStudentName();
        this.dateOfBirth = otherStudent.getDateOfBirth();
        this.gender = otherStudent.getGender();
        this.phoneNumber = otherStudent.getPhoneNumber();
        this.email = otherStudent.getEmail();
        this.address = otherStudent.getAddress();
        this.major = otherStudent.getMajor();
        this.course = otherStudent.getCourse();
        this.gpa = otherStudent.getGpa();
        this.username = otherStudent.getUsername();
        this.password = otherStudent.getPassword();
    }

    public Student(StudentDto studentDto) {
        try {
            this.studentID = Long.parseLong(studentDto.getStudentID());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        this.studentName = studentDto.getStudentName();
        this.dateOfBirth = studentDto.getDateOfBirth();
        this.gender = studentDto.getGender();
        this.phoneNumber = studentDto.getPhoneNumber();
        this.email = studentDto.getEmail();
        this.address = studentDto.getAddress();
        this.major = studentDto.getMajor();
        this.course = studentDto.getCourse();
        this.gpa = Double.parseDouble(studentDto.getGpa());
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGpa(double gpa) {
        this.gpa = (double)Math.round(gpa * 100d) / 100d;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public String getCourse() {
        return course;
    }

    public String toString() {
        return studentID + " " + studentName + " " + gender + " "
             + dateOfBirth + " " + email + " " + phoneNumber + " "
             + address + " " + major + " " + course + " " + gpa;
    }
}
