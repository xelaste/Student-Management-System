package com.acum.exam.repository;

import com.acum.exam.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Student,Integer> {
}
