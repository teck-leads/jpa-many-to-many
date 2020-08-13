package com.techleads.app.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.techleads.app.model.Course;
import com.techleads.app.model.Student;
@Transactional
@Repository
public class StudentRepository {
	Logger logger =LoggerFactory.getLogger(StudentRepository.class);
	@Autowired
	private EntityManager entityManager;
	@Transactional
	public Student findById(Integer id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}
	
	public void deleteById(Integer id) {
		Student student = findById(id);
		
		entityManager.remove(student);
	}
	public Student inserUpdate(Student student) {
		if(StringUtils.isEmpty(student.getId())) {
			entityManager.persist(student);
		}else {
			entityManager.merge(student);
		}
		return student;
	}
	public  void playWithEntityManger() {
		Student student = new Student("PersistMethod-Student");
		entityManager.persist(student);
		entityManager.flush();//changes will go the db
		student.setName("PersistMethod-Student-Updated"); //this also will be updated even it is not requested to save
		entityManager.flush();//all the above changes will go the db and save
		entityManager.refresh(student);
		//entityManager.clear();//clear everything and don't track anything
		student.setName("PersistMethod-Student-do not track this change: detach");
		entityManager.detach(student);
		
	}
	
	public List<Student> findAll(){
		TypedQuery<Student> createNamedQuery = entityManager.createNamedQuery("FIND_ALL_STUDENTS", Student.class);
		List<Student> courses = createNamedQuery.getResultList();
		return courses;
	}
	
	public Student findStudentCourse(Integer id) {
		Student student = entityManager.find(Student.class, id);
		logger.info("Student=> {}=>  "+student);
		List<Course> courses = student.getCourses();
		
		logger.info("courses=> {}=>  "+courses);
		return student;
	}

	
	public void insertStudentCourse(Student student, Course course) {
		entityManager.persist(student);
		entityManager.persist(course);
		
		student.setCreatedDate(LocalDateTime.now());
		course.setCreatedDate(LocalDateTime.now());
		List<Course> courses=new ArrayList<>();
		courses.add(course);
		
		List<Student> students=new ArrayList<>();
		students.add(student);
		
		student.setCourses(courses);
		course.setStudents(students);
		
		//now persist the owning side means which doesn't have mappedBy element
		entityManager.persist(student);
	}

}
