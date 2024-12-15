package com.example.demo.service;

import com.example.demo.obj.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsWithPagination(int pageNo, int pageSize) {
        return studentRepository.getStudentsWithPagination(pageNo, pageSize);
    }

    public int getTotalStudents() {
        return studentRepository.getTotalStudents();
    }

    public Student findStudentByID(Long studentID) {
        return studentRepository.findStudentByID(studentID);
    }

    public Student findStudentByName(String studentName) {
        return studentRepository.findStudentByName(studentName);
    }

    public Student findByEmail(String studentEmail) {
        return studentRepository.findStudentByName(studentEmail);
    }

    public Student createStudent(Student newStudent) {
        return studentRepository.createStudent(newStudent);
    }

    public Student updateStudent(Student currentStudent) {
        return studentRepository.updateStudent(currentStudent);
    }

    public boolean deleteStudent(Long deleteStudentID) {
        return studentRepository.deleteStudent(deleteStudentID);
    }
}