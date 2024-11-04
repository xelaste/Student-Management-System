package com.acum.exam.service;

import com.acum.exam.entity.Course;
import com.acum.exam.repository.CoursesRepository;
import com.acum.exam.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CoursesRepository repository;

    public List<CourseDto> getAllCources(){
        List<CourseDto> courses = new ArrayList<>();
        repository.findAll().forEach(course->{
            CourseDto dto = new CourseDto();
            dto.setId(course.getId());
            dto.setCode(course.getCode());
            dto.setNumberOfStudents(course.getStudents().size());
            dto.setName(course.getName());
            courses.add (dto);
        });
        return courses;
    }

    public CourseDto addCourse (CourseDto dto) {
        Course course = new Course();
        course.setCode(dto.getCode());
        course.setName(dto.getName());
        course = repository.save(course);
        dto.setId(course.getId());
        return dto;
    }
}
