package com.dungken.CRUDStudentMS.service;

import com.dungken.CRUDStudentMS.dao.StudentDAO;
import com.dungken.CRUDStudentMS.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.saveAndPlush(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }
}
