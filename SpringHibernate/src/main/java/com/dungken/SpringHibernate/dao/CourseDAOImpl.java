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
public class CourseDAOImpl implements CourseDAO{
    private EntityManager entityManager;

    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public List<Course> findCoursesByTeacherId(int id) {
        // create query
        String queryStr = "from Course where teacher.id=:x";
        TypedQuery<Course> query = entityManager.createQuery(queryStr, Course.class);
        query.setParameter("x", id);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        // create query
        String queryStr = "select c from Course c JOIN FETCH c.students where c.id=:x";
        TypedQuery<Course> query = entityManager.createQuery(queryStr, Course.class);
        query.setParameter("x", id);

        // execute query
        return query.getSingleResult();
    }
}
