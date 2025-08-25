package com.gk.example.service;

import java.util.List;

import com.gk.example.entities.School;

public interface SchoolService {
    School addSchool(School school);
    List<School> getAllSchools();
    School updateSchool(Long id, School updated);
    School patchSchoolName(Long id, String name);
    void deleteSchool(Long id);
    List<School> findSchoolsByName(String name);
}
