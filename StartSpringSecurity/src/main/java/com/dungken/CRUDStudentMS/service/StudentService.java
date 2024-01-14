package com.dungken.CRUDStudentMS.service;


import com.dungken.CRUDStudentMS.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);

    public List<Student> getAllStudentNotFirstName(String firstName);
}
