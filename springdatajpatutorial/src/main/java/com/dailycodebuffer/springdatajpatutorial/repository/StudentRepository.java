package com.dailycodebuffer.springdatajpatutorial.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);
    @Query(value = "select s from Student s where s.emailId = ?1")
        Student getStudentByEmailAddress(String emailId);
    @Query(value = "select s.firstName from Student s where s.emailId = ?1")
        String getStudentFirstNameByEmailAddress(String emailId);
    @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
        Student getStudentByEmailAddressNative(String emailId);
    @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
        Student getStudentByEmailAddressNativeNamedParam(@Param(value = "emailId") String emailId);
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
        Integer updateStudentNameByEmailId(String firstName, String emailId);
}