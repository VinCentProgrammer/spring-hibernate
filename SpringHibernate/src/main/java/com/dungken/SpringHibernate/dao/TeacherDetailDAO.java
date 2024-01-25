package com.dungken.SpringHibernate.dao;

import com.dungken.SpringHibernate.entity.Teacher;
import com.dungken.SpringHibernate.entity.TeacherDetail;

public interface TeacherDetailDAO {
    public void save(TeacherDetail teacherDetail);

    public TeacherDetail findTeacherDetailById(int id);
    public void delete(int id);
}
