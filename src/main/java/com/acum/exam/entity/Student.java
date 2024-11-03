package com.acum.exam.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="student")
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="student_course_details",
				joinColumns = @JoinColumn(name="student_id"),
				inverseJoinColumns = @JoinColumn(name="course_id"))			
	private List<Course> courses;
	
	public Student() {
		
	}

	public Student(int id, String userName, String password, String firstName, String lastName, String email,
			 List<Course> courses) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.courses = courses;
	}

	public void addCourse(Course course) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}
	
	public boolean equals(Object comparedObject) {
	    if (this == comparedObject) {
	        return true;
	    }

	   if (!(comparedObject instanceof Student comparedStudent)) {
	        return false;
	    }

        return this.id == comparedStudent.id;
    }
	
	
	
}
