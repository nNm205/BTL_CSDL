package com.example.demo.Dto;

import jakarta.validation.constraints.NotEmpty;

public class ScoreDto {
    @NotEmpty(message = "The student id is required")
    private String studentID;

    @NotEmpty(message = "The subject id is required")
    private String subjectID;

    @NotEmpty(message = "diem_cc is required")
    private String diem_cc;

    @NotEmpty(message = "diem_gk is required")
    private String diem_gk;

    @NotEmpty(message = "diem_ck is required")
    private String diem_ck;

    @NotEmpty(message = "diem_tb is required")
    private String diem_tb;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMesage(String message) {
        this.message = message;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getDiem_cc() {
        return diem_cc;
    }

    public void setDiem_cc(String diem_cc) {
        this.diem_cc = diem_cc;
    }

    public String getDiem_gk() {
        return diem_gk;
    }

    public void setDiem_gk(String diem_gk) {
        this.diem_gk = diem_gk;
    }

    public String getDiem_ck() {
        return diem_ck;
    }

    public void setDiem_ck(String diem_ck) {
        this.diem_ck = diem_ck;
    }

    public String getDiem_tb() {
        return diem_tb;
    }

    public void setDiem_tb(String diem_tb) {
        this.diem_tb = diem_tb;
    }
}
