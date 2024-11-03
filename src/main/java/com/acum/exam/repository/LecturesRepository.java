package com.acum.exam.repository;

import com.acum.exam.entity.Lecture;
import org.springframework.data.repository.CrudRepository;
public interface LecturesRepository extends CrudRepository<Lecture,Integer> {
}
