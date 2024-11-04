package com.acum.exam;

import com.acum.exam.application.StudentManagementSystemApplication;
import com.acum.exam.repository.CoursesRepository;
import com.acum.exam.repository.StudentsRepository;
import com.acum.exam.service.CourseService;
import com.acum.exam.service.StudentService;
import com.acum.exam.dto.CourseDto;
import com.acum.exam.dto.StudentDto;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {StudentManagementSystemApplication.class})
class XStudentManagementSystemApplicationTests {

	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;

	@Autowired
	private CoursesRepository courseRepository;

	@Autowired
	private StudentsRepository studentRepository;





	private final Logger logger = LoggerFactory.getLogger(getClass().getName());

	@BeforeEach
	public void cleanDB()
	{
		studentRepository.deleteAll();
		courseRepository.deleteAll();
	}
	@Test
	public void contextLoads() {
			}

    @Test
	public void addNewStudent()
	{
		StudentDto studentDto = new StudentDto();
		studentDto.setEmail("aaaa@bbb.com");
		studentDto.setLastName("John");
		studentDto.setFirstName("Smith");
		studentDto=studentService.create(studentDto);
		assertTrue(studentDto.getId()>0);
	}

	@Test
	public void addNewCourse()
	{
		CourseDto dto = new CourseDto();
		dto.setName("good course");
		dto.setCode("GoodCourseCode");
		dto = courseService.addCourse(dto);
		assertTrue(dto.getId()>0);
	}

	@Test
	public void addNewCourseToStudent()
	{
		CourseDto courseDto = new CourseDto();
		courseDto.setName("good course xx");
		courseDto.setCode("GoodCourseCodeXX");
		courseDto = courseService.addCourse(courseDto);
    	StudentDto studentDto = new StudentDto();
		studentDto.setEmail("xxxx@yyyy.com");
		studentDto.setLastName("Smith");
		studentDto.setFirstName("John");
		studentDto=studentService.create(studentDto);
		studentDto = studentService.addCourseToStudent(studentDto.getId(),courseDto.getId());
		assertTrue(studentDto.getCourses().size()>0);
		assertTrue(studentDto.getCourses().get(0).getNumberOfStudents()>0);
	}

	@Test
	public void getStudents()
	{
		StudentDto studentDto = new StudentDto();
		studentDto.setEmail("aaaa@bbb.com");
		studentDto.setLastName("John");
		studentDto.setFirstName("Smith");
		studentDto=studentService.create(studentDto);

		studentDto = new StudentDto();
		studentDto.setEmail("xxx@bbb.com");
		studentDto.setLastName("Mary");
		studentDto.setFirstName("Stuart");
		studentDto=studentService.create(studentDto);
		List<StudentDto> lst = studentService.findAll();
		assertTrue(lst.size()==2);

	}
	@Test
	public void getCourses()
	{
		CourseDto courseDto = new CourseDto();
		courseDto.setName("good course yy");
		courseDto.setCode("GoodCourseCodeYY");
		courseDto = courseService.addCourse(courseDto);
		StudentDto studentDto = new StudentDto();
		studentDto.setEmail("xxxx@yyyy.com");
		studentDto.setLastName("Smith");
		studentDto.setFirstName("John");
		studentDto=studentService.create(studentDto);
		studentDto = studentService.addCourseToStudent(studentDto.getId(),courseDto.getId());
		courseDto = new CourseDto();
		courseDto.setName("good course ZZ");
		courseDto.setCode("GoodCourseCode");
		courseDto = courseService.addCourse(courseDto);
		studentDto = studentService.addCourseToStudent(studentDto.getId(),courseDto.getId());
		List<CourseDto> lst = courseService.getAllCources();
		assertTrue(lst.size()==2);
	}
}
