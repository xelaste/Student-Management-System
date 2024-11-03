package com.acum.exam.entity;

import java.util.ArrayList;
import java.util.Collections;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity(name="student_course_details")
@Data
public class StudentCourseDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="course_id")
	private int courseId;
	
	public StudentCourseDetails() {
		
	}
    public StudentCourseDetails(int studentId, int courseId			)
	{
		this.studentId = studentId;
		this.courseId = courseId;
	}
}


