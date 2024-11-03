package com.acum.exam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="LECTURE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"COURSE_ID", "EMP_NAME"}))
public class Lecture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    private String title;
    private String description;
    private String order;
}
