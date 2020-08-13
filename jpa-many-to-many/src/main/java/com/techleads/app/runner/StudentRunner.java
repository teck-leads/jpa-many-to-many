package com.techleads.app.runner;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Course;
import com.techleads.app.model.Student;
import com.techleads.app.repository.StudentRepository;
@Component
public class StudentRunner implements CommandLineRunner {
@Autowired
	private StudentRepository studentRepository;
Logger logger =Logger.getLogger(StudentRunner.class);
	@Override
	public void run(String... args) throws Exception {
		
		
		List<Student> findAll = studentRepository.findAll();
		logger.info("ALL Students => {}=>  "+findAll);
		
		Student findStudentCourse = studentRepository.findStudentCourse(300);
		
		logger.info("Student=> {}=>  "+findStudentCourse);
		
		
	
		
		
		Student student=new Student("Dhruvin");
		Course course =new Course("Algebra");
		studentRepository.insertStudentCourse(student, course);
		
	}

}
