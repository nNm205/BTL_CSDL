package com.example.demo.controller;

import com.example.demo.obj.Student;
import com.example.demo.service.ScoreService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/nnm")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("home-page");
        studentService.getStudentList(modelAndView);
        scoreService.getScoreList(modelAndView);
        modelAndView.addObject("showStudentList", true);
        modelAndView.addObject("showScoreList", true);
        return modelAndView;
    }

    @GetMapping("/getStudent/{id}")
    @ResponseBody
    public Student getStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "success";
    }
}
