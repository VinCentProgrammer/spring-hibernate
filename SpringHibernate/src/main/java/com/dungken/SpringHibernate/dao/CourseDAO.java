package com.dungken.SpringHibernate.dao;

import com.dungken.SpringHibernate.entity.Course;

import java.util.List;

public interface CourseDAO {
    public void save(Course course);

    public List<Course> findCoursesByTeacherId(int id);

    public Course findCourseById(int id);

    public Course findCourseAndStudentByCourseId(int id);
}
