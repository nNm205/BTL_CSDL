package com.example.demo.repository;

import com.example.demo.obj.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // show all students
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        String query = "SELECT * FROM students";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query);

        while (rowSet.next()) {
            Student student = new Student();
            try {
                student.setStudentID(rowSet.getLong("student_id"));
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            student.setStudentName(rowSet.getString("student_name"));
            student.setDateOfBirth(rowSet.getString("date_of_birth"));
            student.setEmail(rowSet.getString("email"));

            studentList.add(student);
        }

        return studentList;
    }

    // find student with given name
    public Student findStudentByName(String studentName) {
        String query = "SELECT * FROM students WHERE student_name = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, studentName);

        if (rows.next()) {
            Student student = new Student();
            try {
                student.setStudentID(rows.getLong("student_id"));
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            student.setStudentName(rows.getString("student_name"));
            student.setDateOfBirth(rows.getString("date_of_birth"));
            student.setEmail(rows.getString("email"));

            return student;
        }

        return null;
    }

    // find student with given id
    public Student findStudentByID(Long studentID) {
        String query = "SELECT * FROM students WHERE student_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, studentID);

        if (rows.next()) {
            Student student = new Student();
            try {
                student.setStudentID(rows.getLong("student_id"));
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            student.setStudentName(rows.getString("student_name"));
            student.setDateOfBirth(rows.getString("date_of_birth"));
            student.setEmail(rows.getString("email"));

            return student;
        }

        return null;
    }

    public Student findByEmail(String email) {
        String query = "SELECT * FROM students WHERE email = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, email);

        if (rows.next()) {
            Student student = new Student();
            try {
                student.setStudentID(rows.getLong("student_id"));
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            student.setStudentName(rows.getString("student_name"));
            student.setDateOfBirth(rows.getString("date_of_birth"));
            student.setEmail(rows.getString("email"));

            return student;
        }

        return null;
    }

    // create a new student
    public Student createStudent(Student newStudent) {
        String query = "INSERT INTO students (student_id, student_name, date_of_birth, email)" +
                "VALUES (?, ?, ?, ?)";

        int updateSuccess = jdbcTemplate.update(query,
                newStudent.getStudentID(),
                newStudent.getStudentName(),
                newStudent.getDateOfBirth(),
                newStudent.getEmail());

        if (updateSuccess > 0) {
            long studentID = jdbcTemplate.queryForObject(
                    "SELECT LAST_INSERT_ID()",
                    Integer.class);
            return findStudentByID(studentID);
        }

        return null;
    }

    // update student information
    public Student updateStudent(Student currentStudent) {
        String query = "UPDATE students " +
                "SET student_name = ?," +
                "date_of_birth = ?," +
                "email = ?" +
                "WHERE student_id = ?";

        jdbcTemplate.update(query,
                currentStudent.getStudentName(),
                currentStudent.getDateOfBirth(),
                currentStudent.getEmail(),
                currentStudent.getStudentID());

        return findStudentByID(currentStudent.getStudentID());
    }

    // delete student
    public boolean deleteStudent(Long deleteStudentID) {
        if (deleteStudentID == null || deleteStudentID <= 0) {
            throw new IllegalArgumentException("Mã sinh viên không hợp lệ");
        }

        String query = "DELETE FROM students WHERE student_id = ?";
        try {
            int deleteSuccess = jdbcTemplate.update(query, deleteStudentID);
            return deleteSuccess > 0;
        } catch (NumberFormatException e) {
            System.err.print("Lỗi khi xóa sinh viên: " + e.getMessage());
            return false;
        }
    }
}
