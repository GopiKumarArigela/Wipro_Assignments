package com.gk.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gk.example.entities.School;
import com.gk.example.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolControllers {

    @Autowired
    private SchoolService schoolService;

    @PostMapping
    public School add(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    @GetMapping
    public List<School> getAll() {
        return schoolService.getAllSchools();
    }

    @PutMapping("/{id}")
    public School update(@PathVariable Long id, @RequestBody School updated) {
        return schoolService.updateSchool(id, updated);
    }

    @PatchMapping("/{id}/name")
    public School patchName(@PathVariable Long id, @RequestParam String name) {
        return schoolService.patchSchoolName(id, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        schoolService.deleteSchool(id);
    }

    @GetMapping("/searchByName")
    public List<School> findByName(@RequestParam String name) {
        return schoolService.findSchoolsByName(name);
    }
}
