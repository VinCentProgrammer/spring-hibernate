package com.dungken.SpringMVC.rest;

import com.dungken.SpringMVC.entity.Student;
import com.dungken.SpringMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);
        return "students/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "students/add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        //studentService.updateStudent(student);
        studentService.addStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "students/add";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
}
