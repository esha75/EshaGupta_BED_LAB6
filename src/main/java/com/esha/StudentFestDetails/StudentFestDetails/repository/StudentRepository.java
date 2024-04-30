package com.esha.StudentFestDetails.StudentFestDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esha.StudentFestDetails.StudentFestDetails.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
