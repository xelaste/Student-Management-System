insert into course (code, name, id)  values  ('Course1', 'CourseName1', 1);
insert into course (code, name, id)  values  ('Course2', 'CourseName2', 2);
insert into course (code, name, id)  values  ('Course3', 'CourseName3', 3);
insert into course (code, name, id)  values  ('Course4', 'CourseName4', 4);
insert into course (code, name, id)  values  ('Course5', 'CourseName5', 5);


insert into student (email, first_name, last_name, id) values ('student1@email.com', 'student1FN', 'student2LN', 1);
insert into student (email, first_name, last_name, id) values ('student2@email.com', 'student2FN', 'student2LN', 2);
insert into student (email, first_name, last_name, id) values ('student3@email.com', 'student3FN', 'student2LN', 3);
insert into student (email, first_name, last_name, id) values ('student4@email.com', 'student4FN', 'student2LN', 4);
insert into student (email, first_name, last_name, id) values ('student5@email.com', 'student5FN', 'student2LN', 5);

insert into student_course_details (student_id, course_id)   values     (1, 1);
insert into student_course_details (student_id, course_id)   values     (1, 2);
insert into student_course_details (student_id, course_id)   values     (1, 3);
insert into student_course_details (student_id, course_id)   values     (2, 1);
insert into student_course_details (student_id, course_id)   values     (2, 2);
insert into student_course_details (student_id, course_id)   values     (3, 3);
insert into student_course_details (student_id, course_id)   values     (3, 4);
insert into student_course_details (student_id, course_id)   values     (4, 1);
insert into student_course_details (student_id, course_id)   values     (5, 2);
