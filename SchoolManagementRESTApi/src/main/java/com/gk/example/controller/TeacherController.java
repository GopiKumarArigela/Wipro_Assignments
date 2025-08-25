package com.gk.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.example.entities.Teacher;
import com.gk.example.repo.TeacherRepository;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepo;

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @GetMapping
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    @GetMapping("/experienced")
    public List<Teacher> getExperienced(@RequestParam int exp) {
        return teacherRepo.findByExperienceGreaterThan(exp);
    }

    @GetMapping("/qualification")
    public List<Teacher> getByQualification(@RequestParam String q) {
        return teacherRepo.findByQualification(q.toUpperCase());
    }
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Long id, @RequestBody Teacher updatedTeacher) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        
        teacher.setTeacherName(updatedTeacher.getTeacherName());
        teacher.setTeacherAdress(updatedTeacher.getTeacherAdress());
        teacher.setQualification(updatedTeacher.getQualification());
        teacher.setAge(updatedTeacher.getAge());
        teacher.setDob(updatedTeacher.getDob());
        teacher.setExperience(updatedTeacher.getExperience());
        
        return teacherRepo.save(teacher);
    }
    @PatchMapping("/{id}/name")
    public Teacher updateTeacherName(@PathVariable Long id, @RequestParam String name) {
        Teacher teacher = teacherRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));

        teacher.setTeacherName(name);
        return teacherRepo.save(teacher);
    }


}
