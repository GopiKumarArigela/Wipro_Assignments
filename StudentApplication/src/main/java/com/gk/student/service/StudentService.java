package com.gk.student.service;

import java.util.List;

import com.gk.student.entities.Student;


public interface StudentService {

	public List<Student> getAll();

	public void save(Student student);

	public Student getById(Long id);

	public void delete(Long id);

}
