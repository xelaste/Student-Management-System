package com.acum.exam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="LECTURE",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"COURSE_ID", "LECTURE_ORDER"}))
public class Lecture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    private String title;
    private String description;
    private int lectureOrder;
}
