package com.dungken.CRUDStudentMS.dao;

import com.dungken.CRUDStudentMS.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String jpql = "SELECT s FROM Student s";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    public Student saveAndPlush(Student student) {
        student = entityManager.merge(student);
        entityManager.flush();
        return student;
    }

    @Override
    public void delete(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
