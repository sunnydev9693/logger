package com.example.logger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.logger.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
