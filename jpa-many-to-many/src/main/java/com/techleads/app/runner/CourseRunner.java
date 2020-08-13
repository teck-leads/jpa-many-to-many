package com.techleads.app.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Course;
import com.techleads.app.model.Student;
import com.techleads.app.repository.CourseRepository;

//@Component
@Transactional
public class CourseRunner implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	
	private Logger logger = LoggerFactory.getLogger(CourseRepository.class);

	@Autowired
	private EntityManager em;
	@Override
	public void run(String... args) throws Exception {
		
		Course findCourseStudent = courseRepository.findCourseStudent(101);
		logger.info("Course=> {}=>  "+findCourseStudent);
		List<Student> students = findCourseStudent.getStudents();
		
		logger.info("students=> {}=>  "+students);
	}

}
