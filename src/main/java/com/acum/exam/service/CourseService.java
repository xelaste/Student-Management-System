package com.acum.exam.service;

import com.acum.exam.entity.Course;
import com.acum.exam.repository.CoursesRepository;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CoursesRepository repository;

    public List<Course> getAllCources(){
        List<Course> courses = new ArrayList<>();
        repository.findAll().forEach(courses::add);
        return courses;
    }
}
