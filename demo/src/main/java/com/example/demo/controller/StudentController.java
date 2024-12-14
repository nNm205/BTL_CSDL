package com.example.demo.controller;

import com.example.demo.StudentDto;
import com.example.demo.obj.Student;
import com.example.demo.repository.StudentRepository;
import jakarta.validation.Valid;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"", "/"})
    public String getStudentList(Model model) {
        var studentList = studentRepository.findAll(Sort.by(Sort.Direction.DESC, "studentID"));
        model.addAttribute("studentList", studentList);
        return "students/home-page";
    }

    @GetMapping("/create")
    public String createStudent(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);

        return "students/create";
    }

    @PostMapping("/create")
    public String createStudent(@Valid StudentDto studentDto,
                                BindingResult bindingResult) {
        if (studentRepository.findByStudentID(Long.parseLong(studentDto.getStudentID())) != null) {
            bindingResult.addError(
                    new FieldError("studentDto",
                            "studentID",
                            studentDto.getStudentID(),
                            false,
                            null,
                            null,
                            "Student ID is already in use")
            );
        }

        if (bindingResult.hasErrors()) {
            return "students/create";
        }

        try {
            Student student = new Student();
            student.setVersion(0L);
            student.setStudentID(Long.parseLong(studentDto.getStudentID()));
            student.setStudentName(studentDto.getStudentName());
            student.setDateOfBirth(studentDto.getDateOfBirth());
            student.setEmail(studentDto.getEmail());

            studentRepository.save(student);
            return "redirect:/students";
        } catch (ObjectOptimisticLockingFailureException e) {
            bindingResult.addError(new FieldError("studentDto",
                    "studentID",
                    "Data was modified by another user. Please try again."));
            return "students/create";
        }
    }
}

