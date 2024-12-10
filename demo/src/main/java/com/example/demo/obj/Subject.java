package com.example.demo.obj;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private long subjectID;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "number_of_credits")
    private Integer numberOfCredits;

    public Subject() {

    }

    public Subject(long subjectID, String subjectName, int numberOfCredits) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.numberOfCredits = numberOfCredits;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectID(long subjectID) {
        this.subjectID = subjectID;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public long getSubjectID() {
        return subjectID;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }
}
