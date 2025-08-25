package com.gk.student.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String studentMail;
    private String rollNo;
    private Integer age;
    private String dob;
    private String gender;
    private String address;

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public String getRollNo() {
        return rollNo;
    }

    public Integer getAge() {
        return age;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    // --- Setters ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
