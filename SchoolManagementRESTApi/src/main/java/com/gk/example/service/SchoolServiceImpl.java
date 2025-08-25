package com.gk.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gk.example.entities.School;
import com.gk.example.repo.SchoolRepository;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolRepository schoolRepo;

    @Override
    public School addSchool(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    @Override
    public School updateSchool(Long id, School updated) {
        School s = schoolRepo.findById(id).orElseThrow();
        s.setSchoolName(updated.getSchoolName());
        s.setSchoolAdress(updated.getSchoolAdress());
        return schoolRepo.save(s);
    }

    @Override
    public School patchSchoolName(Long id, String name) {
        School s = schoolRepo.findById(id).orElseThrow();
        s.setSchoolName(name);
        return schoolRepo.save(s);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepo.deleteById(id);
    }

    @Override
    public List<School> findSchoolsByName(String name) {
        return schoolRepo.findBySchoolNameContainingIgnoreCase(name);
    }
}
