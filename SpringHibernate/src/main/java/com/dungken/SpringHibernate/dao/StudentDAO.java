package com.dungken.SpringHibernate.dao;

import com.dungken.SpringHibernate.entity.Student;

public interface StudentDAO {
    public void save(Student student);

    public Student findStudentById(int id);

    public Student findStudentAndCourseByStudentId(int id);
}
