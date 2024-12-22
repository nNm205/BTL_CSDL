package com.example.demo.repository;

import com.example.demo.obj.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

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

            student.setStudentName(studentName);
            student.setGender(rows.getString("gender"));
            student.setGpa(rows.getFloat("gpa"));
            student.setMajor(rows.getString("major"));
            student.setCourse(rows.getString("course"));
            student.setDateOfBirth(LocalDate.parse(rows.getString("date_of_birth")));
            student.setEmail(rows.getString("email"));
            student.setAddress(rows.getString("address"));
            student.setPhoneNumber(rows.getString("phone_number"));

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
                student.setStudentID(studentID);
            } catch (NumberFormatException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            student.setStudentName(rows.getString("student_name"));
            student.setGender(rows.getString("gender"));
            student.setGpa(rows.getFloat("gpa"));
            student.setMajor(rows.getString("major"));
            student.setCourse(rows.getString("course"));
            student.setDateOfBirth(LocalDate.parse(rows.getString("date_of_birth")));
            student.setEmail(rows.getString("email"));
            student.setAddress(rows.getString("address"));
            student.setPhoneNumber(rows.getString("phone_number"));

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
            student.setGender(rows.getString("gender"));
            student.setGpa(rows.getFloat("gpa"));
            student.setMajor(rows.getString("major"));
            student.setCourse(rows.getString("course"));
            student.setDateOfBirth(LocalDate.parse(rows.getString("date_of_birth")));
            student.setEmail(email);
            student.setAddress(rows.getString("address"));
            student.setPhoneNumber(rows.getString("phone_number"));

            return student;
        }

        return null;
    }

    // create a new student
    public Student createStudent(Student newStudent) {
        String query = "INSERT INTO students (student_id, student_name, gender, gpa, date_of_birth, " +
                "phone_number, email, address, major, course)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        int updateSuccess = jdbcTemplate.update(query,
                newStudent.getStudentID(),
                newStudent.getStudentName(),
                newStudent.getGender(),
                newStudent.getGpa(),
                newStudent.getDateOfBirth(),
                newStudent.getPhoneNumber(),
                newStudent.getEmail(),
                newStudent.getAddress(),
                newStudent.getMajor(),
                newStudent.getCourse());

        if (updateSuccess > 0) {
            return findStudentByID(newStudent.getStudentID());
        }

        return null;
    }

    // update student information
    public Student updateStudent(Student currentStudent) {
        String query = "UPDATE students " +
                "SET student_name = ?," +
                "gender = ?," +
                "gpa = ?" +
                "date_of_birth = ?," +
                "phone_number = ?" +
                "email = ?" +
                "address = ?" +
                "major = ?," +
                "course = ?" +
                "WHERE student_id = ?";

        jdbcTemplate.update(query,
                currentStudent.getStudentName(),
                currentStudent.getGender(),
                currentStudent.getGpa(),
                currentStudent.getDateOfBirth(),
                currentStudent.getPhoneNumber(),
                currentStudent.getEmail(),
                currentStudent.getAddress(),
                currentStudent.getMajor(),
                currentStudent.getCourse(),
                currentStudent.getStudentID());

        return findStudentByID(currentStudent.getStudentID());
    }

    // delete student
    public boolean deleteStudent(Long deleteStudentID) {
        String query = "DELETE FROM students WHERE student_id = ?";
        try {
            int deleteSuccess = jdbcTemplate.update(query, deleteStudentID);
            return deleteSuccess > 0;
        } catch (NumberFormatException e) {
            System.err.print("Lỗi khi xóa sinh viên: " + e.getMessage());
            return false;
        }
    }

    public List<Student> getStudentsWithPagination(int pageNo, int pageSize) {
        List<Student> studentList = new ArrayList<>();
        int offset = (pageNo - 1) * pageSize;

        String query = "SELECT * FROM students LIMIT ? OFFSET ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, pageSize, offset);

        while (rowSet.next()) {
            Student student = new Student();
            student.setStudentID(rowSet.getLong("student_id"));
            student.setStudentName(rowSet.getString("student_name"));
            student.setGender(rowSet.getString("gender"));
            student.setGpa(rowSet.getFloat("gpa"));
            student.setDateOfBirth(LocalDate.parse(rowSet.getString("date_of_birth")));
            student.setPhoneNumber(rowSet.getString("phone_number"));
            student.setEmail(rowSet.getString("email"));
            student.setAddress(rowSet.getString("address"));
            student.setMajor(rowSet.getString("major"));
            student.setCourse(rowSet.getString("course"));
            studentList.add(student);
        }

        return studentList;
    }

    public int getTotalStudents() {
        String query = "SELECT COUNT(*) FROM students";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }

    public boolean isValidStudentID(long studentID) {
        String query = "SELECT * FROM students WHERE student_id = ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(query, studentID);
        if (rows.next()) {
            return true;
        } else {
            return false;
        }
    }
}
