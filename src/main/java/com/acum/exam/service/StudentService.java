package com.acum.exam.service;

import com.acum.exam.entity.Course;
import com.acum.exam.entity.Student;
import com.acum.exam.repository.CoursesRepository;
import com.acum.exam.repository.StudentsRepository;
import com.acum.exam.dto.CourseDto;
import com.acum.exam.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository repository;
    @Autowired
    private CoursesRepository coursesRepository;

    public StudentDto create(StudentDto studentDto) {
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student = repository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    public StudentDto update(StudentDto studentDto) {
        Student student = repository.findById(studentDto.getId()).orElse(null);
        if (student == null ) {
            throw new RuntimeException("Invalid Student Id");
        }
        student.setEmail(studentDto.getEmail());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student = repository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    public StudentDto addCourseToStudent(Integer studentId, Integer courseId) {
        Student student = repository.findById(studentId).orElse(null);
        Course course = coursesRepository.findById(courseId).orElse(null);
        if (course != null && student != null) {
            student.getCourses().add(course);
            repository.save(student);
            student = repository.findById(studentId).orElse(null);
            return mapStudent2Dto(student);

        } else {
            throw new RuntimeException("Provided Course or Student id are not valid");
        }

    }

    public StudentDto deleteCourseFromStudent(Integer studentId, Integer courseId) {
        Student student = repository.findById(studentId).orElse(null);
        Course course = coursesRepository.findById(courseId).orElse(null);
        if (course != null && student != null) {
            Course courseforRemove = student.getCourses().stream().filter(x -> x.getId() == course.getId()).findFirst().orElse(null);
            if (courseforRemove != null) {
                student.getCourses().remove(courseforRemove);
            }
            student = repository.save(student);
            return mapStudent2Dto(student);
        } else {
            throw new RuntimeException("Provided Course or Student id are not valid");
        }
    }

    public StudentDto findById(Integer id) {
        Student student = repository.findById(id).orElse(null);
        if (student != null) {
            return mapStudent2Dto(student);
        } else {
            return null;
        }
    }
    public List<StudentDto> findAll() {
        List<StudentDto> students = new ArrayList<>();
       repository.findAll().forEach(
               student->{
                   StudentDto dto = mapStudent2Dto(student);
                   students.add(dto);
               }
       );
       return students;
    }
    private StudentDto mapStudent2Dto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setEmail(student.getEmail());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        student.getCourses().forEach(course -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setCode(course.getCode());
            courseDto.setId(course.getId());
            courseDto.setName(course.getName());
            courseDto.setNumberOfStudents(course.getStudents().size());
            dto.getCourses().add(courseDto);
        });
        return dto;
    }
}
