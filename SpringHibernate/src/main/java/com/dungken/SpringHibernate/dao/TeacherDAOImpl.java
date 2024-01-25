package com.dungken.SpringHibernate.dao;

import com.dungken.SpringHibernate.entity.Course;
import com.dungken.SpringHibernate.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeacherDAOImpl implements TeacherDAO{
    private EntityManager entityManager;

    @Autowired
    public TeacherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void delete(int id) {
        // find
        Teacher teacher = entityManager.find(Teacher.class, id);
        // delete
        entityManager.remove(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
        entityManager.flush();
    }

    @Override
    public Teacher findTeacherByIdJoinFetch(int id) {
        // create query
        String queryStr = "select t from Teacher t JOIN FETCH t.courses JOIN FETCH t.teacherDetail where t.id=:x";
        TypedQuery<Teacher> query = entityManager.createQuery(queryStr, Teacher.class);
        query.setParameter("x", id);

        // execute query
        Teacher teacher = query.getSingleResult();

        return teacher;
    }
}
