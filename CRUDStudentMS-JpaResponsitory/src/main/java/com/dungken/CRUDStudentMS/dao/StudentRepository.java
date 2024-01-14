package com.dungken.CRUDStudentMS.dao;

import com.dungken.CRUDStudentMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Co the viet cac phuong thuc khac
}
