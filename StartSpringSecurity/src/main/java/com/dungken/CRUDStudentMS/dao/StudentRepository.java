package com.dungken.CRUDStudentMS.dao;

import com.dungken.CRUDStudentMS.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Co the viet cac phuong thuc khac
    // Lay ra students la firstName
    List<Student> findByFirstName(String firstName);

    // Lay ra students la lastName
    List<Student> findByLastName(String lastName);

    // Lay ra students la email
    Optional<Student> findByEmail(String email);

    // Lay ra students la co firstName khac voi gia tri tim kiem
    //List<Student> findByFirstNameNot(String firstName);

    // Lay ra students la co firstName khac voi gia tri tim kiem
    @Query("SELECT s FROM Student s WHERE s.firstName <> ?1")
    List<Student> findByFirstNameNot(String firstName);
}
