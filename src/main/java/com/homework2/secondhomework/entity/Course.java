package com.homework2.secondhomework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int courseCod;
    private int creditScore;

    @ManyToMany(mappedBy = "courseList")
    @JsonIgnore
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private Instructor instructor;

    public Course(String courseName, int courseCod, int creditScore) {
        this.courseName = courseName;
        this.courseCod = courseCod;
        this.creditScore = creditScore;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCod() {
        return courseCod;
    }

    public void setCourseCod(int courseCod) {
        this.courseCod = courseCod;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseCod == course.courseCod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCod);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCod=" + courseCod +
                ", creditScore=" + creditScore +
                '}';
    }
}
