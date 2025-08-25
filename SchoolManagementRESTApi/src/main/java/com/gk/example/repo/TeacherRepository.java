package com.gk.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gk.example.entities.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    
    List<Teacher> findByQualification(String qualification);

    
    @Query(value = "SELECT * FROM teacher WHERE experience >= ?1", nativeQuery = true)
    List<Teacher> findByExperienceGreaterThan(int experience);

}
