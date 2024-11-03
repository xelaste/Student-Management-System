package com.acum.exam.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name="code")
	private String code;
	
	@NotBlank(message = "is required")
	@Size(min = 1, message = "is required")
	@Column(name="name")
	private String name;
	

	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinTable(name="student_course_details",
				joinColumns = @JoinColumn(name="course_id"),
				inverseJoinColumns = @JoinColumn(name="student_id"))			
	private List<Student> students;
	

	@OneToMany(mappedBy = "LECTURES", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Lecture> lectures = new ArrayList<>();;
	

	public Course() {
		
	}


	public Course(int id, String code, String name, List<Student> students) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.students = students;
	}


	public int studentListSize() {
		return students.size();
	}
	
	public void addStudent(Student student) {
		if(students == null) {
			students = new ArrayList<>();
		}
		students.add(student);
	}
	
	public void removeStudent(Student student) {
			students.remove(student);
	}
	
	public boolean equals(Object comparedObject) {
	    if (this == comparedObject) {
	        return true;
	    }

	   if (!(comparedObject instanceof Course comparedCourse)) {
	        return false;
	    }
        return this.id == comparedCourse.id;
    }

}