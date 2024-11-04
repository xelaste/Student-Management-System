package com.acum.exam.controller;

import com.acum.exam.dto.CourseDto;
import com.acum.exam.dto.StudentCourseDataDto;
import com.acum.exam.dto.StudentDto;
import com.acum.exam.service.CourseService;
import com.acum.exam.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentManagementController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<CourseDto> findAllCources() {
        return courseService.getAllCources();
    }

    @GetMapping("/students/{studentId}")
    public StudentDto findStudentById(@PathVariable int studentId) {
        return studentService.findById(studentId);
    }

    @GetMapping("/students")
    public List<StudentDto> findStudentById() {
        return studentService.findAll();
    }

    @PostMapping("/students")
    public StudentDto createStudent(@RequestBody StudentDto dto) {
        return studentService.create(dto);
    }

    @PutMapping("/students")
    public StudentDto updateStudent(@RequestBody StudentDto dto) {
        return studentService.update(dto);
    }

    @PostMapping("/students/courses")
    public StudentDto addCourseStudent(@RequestBody StudentCourseDataDto dto) {
        return studentService.addCourseToStudent(dto.getStudentId(), dto.getCourseId());
    }

    @PutMapping("/students/courses")
    public StudentDto deleteCourseFromStudent(@RequestBody StudentCourseDataDto dto) {
        return studentService.deleteCourseFromStudent(dto.getStudentId(), dto.getCourseId());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleException(Exception exception) {
        return new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
    @Data
    @AllArgsConstructor
    public static class ErrorMessage {
        private String message;
        private int errorCode;
    }
}
