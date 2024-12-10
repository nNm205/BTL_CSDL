package com.example.demo.controller;

import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.example.demo.obj.Student;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public String student(Model model) {
        List<Student> studentList = studentRepository.findAll();
        model.addAttribute("studentList", studentList);
        return "home-page";
    }
}
