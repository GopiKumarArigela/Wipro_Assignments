package com.gk.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gk.student.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
