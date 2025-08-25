package com.gk.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gk.student.entities.Student;
import com.gk.student.service.StudentService;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public String viewbase(Model model) {
        return "base";
    }
    

    @GetMapping("show")
    public String viewHome(Model model) {
        model.addAttribute("list", studentService.getAll());
        return "show";
    }
    
    @GetMapping("create")
    public String viewcreate(Model model) {
        model.addAttribute("list", studentService.getAll());
        model.addAttribute("student", new Student()); 
        return "create";
    }
    
    @GetMapping("update")
    public String viewupdate(Model model) {
        model.addAttribute("list", studentService.getAll());
        return "update";
    }
    
    @GetMapping("delete")
    public String viewdelete(Model model) {
        model.addAttribute("list", studentService.getAll());
        return "delete";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
