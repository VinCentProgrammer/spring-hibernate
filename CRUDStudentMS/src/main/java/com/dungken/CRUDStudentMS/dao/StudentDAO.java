package com.dungken.CRUDStudentMS.dao;

import com.dungken.CRUDStudentMS.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();
    public Student getById(int id);

    public Student save(Student student);

    public Student saveAndPlush(Student student);

    public void delete(int id);
}
