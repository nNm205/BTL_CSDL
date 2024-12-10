package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private long studentID;

    @Column(name = "subject_id")
    private long subjectID;

    @Column(name = "diem_cc")
    private double diem_cc;

    @Column(name = "diem_gk")
    private double diem_gk;

    @Column(name = "diem_ck")
    private double diem_ck;

    @Column(name = "diem_tb")
    private double diem_tb;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", insertable = false, updatable = false)
    private Subject subject;

    public Score() {

    }

    public Score(long studentID, long subjectID, double diem_cc, double diem_gk, double diem_ck, double diem_tb) {
        this.studentID = studentID;
        this.subjectID = subjectID;
        this.diem_cc = diem_cc;
        this.diem_gk = diem_gk;
        this.diem_ck = diem_ck;
        this.diem_tb = diem_tb;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public void setSubjectID(long subjectID) {
        this.subjectID = subjectID;
    }

    public void setDiem_cc(double diem_cc) {
        this.diem_cc = diem_cc;
    }

    public void setDiem_gk(double diem_gk) {
        this.diem_gk = diem_gk;
    }

    public void setDiem_ck(double diem_ck) {
        this.diem_ck = diem_ck;
    }

    public void setDiem_tb(double diem_tb) {
        this.diem_tb = diem_tb;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public long getStudentID() {
        return studentID;
    }

    public long getSubjectID() {
        return subjectID;
    }

    public double getDiem_cc() {
        return diem_cc;
    }

    public double getDiem_gk() {
        return diem_gk;
    }

    public double getDiem_ck() {
        return diem_ck;
    }

    public double getDiem_tb() {
        return diem_tb;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }
}
