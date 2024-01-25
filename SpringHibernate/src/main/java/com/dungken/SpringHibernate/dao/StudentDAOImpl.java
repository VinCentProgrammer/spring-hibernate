package com.dungken.SpringHibernate.dao;

import com.dungken.SpringHibernate.entity.Course;
import com.dungken.SpringHibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        // create query
        String queryStr = "select s from Student s JOIN FETCH s.courses where s.id=:x";
        TypedQuery<Student> query = entityManager.createQuery(queryStr, Student.class);
        query.setParameter("x", id);

        // execute query
        return query.getSingleResult();
    }
}
