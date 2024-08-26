package com.example.logger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.logger.model.Student;
import com.example.logger.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	
	public Student addStudent(Student student) {
		
		return studentRepo.save(student);
	}

	public List<Student> findAllStudent() {
		return studentRepo.findAll();
	}

}
