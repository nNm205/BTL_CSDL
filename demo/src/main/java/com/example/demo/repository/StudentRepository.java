package com.example.demo.repository;

import com.example.demo.obj.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByStudentName(String studentName);

    public Student findByStudentID(Long StudentID);
}
