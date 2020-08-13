package com.techleads.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NamedQueries(value = { 
		@NamedQuery(name = "FIND_ALL_STUDENTS", query = "SELECT r FROM Student r")
		})


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name ="STUDENT" )
@SequenceGenerator(name = "student_seq", initialValue = 500, allocationSize = 1)
@ToString(exclude="courses")
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	private Integer id;
	private String name;
	//the entity that doesn't have mappedBy is the association owning entity
	//By default ManyToMany is lazy fetching
	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE",
	joinColumns=@JoinColumn(name = "STUDENT_ID"),
	inverseJoinColumns=@JoinColumn(name = "COURSE_ID")
	
			)
	private List<Course> courses =new ArrayList<>();


	public Student(String name) {
		this.name = name;
	}

	@UpdateTimestamp
	@Column(name = "LAST_UPDATED")
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

	
	
	
	

}
