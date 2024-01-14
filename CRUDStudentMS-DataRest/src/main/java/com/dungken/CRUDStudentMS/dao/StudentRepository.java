package com.dungken.CRUDStudentMS.dao;

import com.dungken.CRUDStudentMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Co the viet cac phuong thuc khac
}
