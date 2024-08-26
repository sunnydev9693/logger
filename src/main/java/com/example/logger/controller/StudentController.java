package com.example.logger.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.logger.model.Student;
import com.example.logger.service.StudentService;


@RestController
@RequestMapping("api/v1/students")
public class StudentController {
	private static final Logger logger = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@PostMapping("")
	public Student addStudent(@RequestBody Student student) {
		logger.debug("Received request to add student: {}", student);
        try {
            Student savedStudent = studentService.addStudent(student);
            logger.info("Student added successfully: {}", savedStudent);
            return savedStudent;
        } catch (Exception e) {
            logger.error("Error occurred while adding student: {}", student, e);
            throw e;
        }
	}
	
	@GetMapping("")
	public List<Student> getAllStudent(){
		logger.debug("This is a debug message");
	    logger.info("This is an info message");
	    logger.warn("This is a warning message");
	    logger.error("This is an error message");
		return studentService.findAllStudent();
	}
	
}
