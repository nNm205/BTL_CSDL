package com.example.demo.service;

import com.example.demo.obj.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void getStudentList(ModelAndView modelAndView) {
        List<Student> studentList = studentRepository.findAll();
        modelAndView.addObject("studentList", studentList);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }
}