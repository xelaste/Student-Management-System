package com.acum.exam.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDto {
    private int id;
	private String firstName;
    private String lastName;
    private String email;
	private List<CourseDto> courses=new ArrayList<>();

}
