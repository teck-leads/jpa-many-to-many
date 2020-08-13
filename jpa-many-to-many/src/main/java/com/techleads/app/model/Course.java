package com.techleads.app.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "course_seq", initialValue = 2001, allocationSize = 1)
@ToString(exclude="students")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	private Integer id;
	private String name;

	public Course(String name) {
		super();
		this.name = name;
	}
	//the entity that doesn't have mappedBy is the association owning entity
	//by default Lazy fetching
	//@ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
	@ManyToMany(mappedBy = "courses", fetch = FetchType.EAGER)
	private List<Student> students =new ArrayList<>();

	@UpdateTimestamp
	@Column(name = "LAST_UPDATED")
	private LocalDateTime lastUpdatedDate;
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDateTime createdDate;

}
