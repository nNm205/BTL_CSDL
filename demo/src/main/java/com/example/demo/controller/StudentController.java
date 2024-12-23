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
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 20;
        }

        List<Student> studentList = studentService.getStudentsWithPagination(page, size);
        int totalStudents = studentService.getTotalStudents();
        int totalPages = (int) Math.ceil((double) totalStudents / size);
        if (totalPages == 0) {
            totalPages = 1;
        }

        model.addAttribute("studentList", studentList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        return "students/student-list";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);

        return "/students/create";
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

        Student student = new Student(studentDto);

        if (bindingResult.hasErrors()) {
            return "/students/create";
        }

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

        System.out.println(student.toString());
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentID(String.valueOf(studentID));
        studentDto.setStudentName(student.getStudentName());
        studentDto.setGender(student.getGender());
        studentDto.setDateOfBirth(student.getDateOfBirth());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setAddress(student.getAddress());
        studentDto.setMajor(student.getMajor());
        studentDto.setCourse(student.getCourse());
        studentDto.setGpa(String.valueOf(student.getGpa()));
        System.out.println(studentDto.toString());

        model.addAttribute("studentDto", studentDto);
        return "/students/edit";
    }

    @PostMapping("/edit/{studentID}")
    public String editStudent(@PathVariable Long studentID,
                              @Valid @ModelAttribute("studentDto") StudentDto studentDto,
                              RedirectAttributes redirectAttributes) {
        Student student = studentService.findStudentByID(studentID);
        if (student == null) {
            return "redirect:/students";
        }

        System.out.println(studentDto.toString());
        student.setStudentName(studentDto.getStudentName());
        student.setGender(studentDto.getGender());
        student.setGpa(Double.parseDouble(studentDto.getGpa()));
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());
        student.setMajor(studentDto.getMajor());
        student.setCourse(studentDto.getCourse());

        studentService.updateStudent(student);
        redirectAttributes
                .addFlashAttribute("successMessage",
                        "Cập nhật thông tin sinh viên thành công!");
        return "redirect:/students";
    }

    @GetMapping("/delete/{studentID}")
    public String deleteStudent(@PathVariable Long studentID,
                                RedirectAttributes redirectAttributes) {
        try {
            boolean isDeleted = studentService.deleteStudent(studentID);
            if (isDeleted) {
                redirectAttributes.addFlashAttribute("successMessage",
                        "Xóa dữ liệu sinh viên thành công!");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage",
                        "Không tìm thấy sinh viên để xóa!");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa sinh viên: " + e.getMessage());
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Xóa dữ liệu sinh viên thất bại. Vui lòng thử lại!");
        }
        return "redirect:/students";
    }

}

