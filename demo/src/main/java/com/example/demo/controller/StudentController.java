package com.example.demo.controller;

import com.example.demo.Dto.StudentDto;
import com.example.demo.obj.Student;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"", "/"})
    public String getStudentList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size,
            Model model) {

        List<Student> studentList = studentService.getStudentsWithPagination(page, size);
        int totalStudents = studentService.getTotalStudents();
        int totalPages = (int) Math.ceil((double) totalStudents / size);

        model.addAttribute("studentList", studentList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "students/home-page";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);

        return "students/create";
    }

    @PostMapping("/create")
    public String creatStudent(
            @Valid @ModelAttribute("studentDto") StudentDto studentDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (studentService.findByEmail(studentDto.getEmail()) != null) {
            bindingResult.addError(
                    new FieldError("studentDto",
                            "email",
                            "Email address is already in use")
            );
        }

        Student student = new Student();
        try {
            student.setStudentID(Long.parseLong(studentDto.getStudentID()));
        } catch(NumberFormatException e) {
            bindingResult.addError(
                    new FieldError("studentDto",
                            "Student ID",
                            studentDto.getStudentID(),
                            false, null, null,
                            "Invalid Student ID format")
            );
        }

        if (bindingResult.hasErrors()) {
            return "students/create";
        }

        student.setStudentName(studentDto.getStudentName());
        student.setGender(studentDto.getGender());
        student.setGpa(Float.parseFloat(studentDto.getGpa()));
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());
        student.setMajor(studentDto.getMajor());
        student.setCourse(studentDto.getCourse());

        studentService.createStudent(student);
        redirectAttributes.addFlashAttribute("successMessage", "Tạo sinh viên mới thành công");
        return "redirect:/students";
    }

    @GetMapping("/edit/{studentID}")
    public String showEditPage(
            Model model,
            @PathVariable Long studentID) {
        Student student = studentService.findStudentByID(studentID);
        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentID(String.valueOf(studentID));
        studentDto.setStudentName(student.getStudentName());
        studentDto.setGender(student.getGender() != null ? student.getGender() : "Nam");
        studentDto.setGpa(String.valueOf(student.getGpa()));
        studentDto.setDateOfBirth(student.getDateOfBirth());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setEmail(student.getEmail());
        studentDto.setAddress(student.getAddress());
        studentDto.setMajor(student.getMajor());
        studentDto.setCourse(student.getCourse());

        model.addAttribute("studentDto", studentDto);
        return "students/edit";
    }

    @PostMapping("/edit/{studentID}")
    public String editStudent(Model model,
                              @PathVariable Long studentID,
                              @Valid @ModelAttribute("studentDto") StudentDto studentDto,
                              RedirectAttributes redirectAttributes) {
        Student student = studentService.findStudentByID(studentID);
        if (student == null) {
            return "redirect:/students";
        }

        student.setStudentName(studentDto.getStudentName());
        student.setGender(studentDto.getGender());
        student.setGpa(Float.parseFloat(studentDto.getGpa()));
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());
        student.setMajor(studentDto.getMajor());
        student.setCourse(studentDto.getCourse());

        studentService.updateStudent(student);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật thông tin sinh viên thành công!");
        return "redirect:/students";
    }

    @GetMapping("/delete/{studentID}")
    public String deleteStudent(@PathVariable Long studentID,
                                RedirectAttributes redirectAttributes) {
        try {
            studentService.deleteStudent(studentID);
            redirectAttributes
                    .addFlashAttribute("successMessage",
                            "Xóa sinh viên thành công!");
        } catch (Exception e) {
            redirectAttributes
                    .addFlashAttribute("errorMessage",
                    "Không thể xóa sinh viên, vui lòng thử lại!");
        }
        return "redirect:/students";
    }
}

