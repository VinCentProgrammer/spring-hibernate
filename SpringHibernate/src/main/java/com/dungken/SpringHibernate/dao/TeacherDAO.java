package com.dungken.SpringHibernate.dao;

import com.dungken.SpringHibernate.entity.Teacher;

public interface TeacherDAO {
    public void save(Teacher teacher);

    public Teacher findTeacherById(int id);

    public void delete(int id);

    public void update(Teacher teacher);

    public Teacher findTeacherByIdJoinFetch(int id);

}
