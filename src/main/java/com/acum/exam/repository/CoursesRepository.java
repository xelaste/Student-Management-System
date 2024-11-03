package com.acum.exam.repository;

import com.acum.exam.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepository extends CrudRepository<Course,Integer> {
}
