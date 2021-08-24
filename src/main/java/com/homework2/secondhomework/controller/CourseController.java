package com.homework2.secondhomework.controller;

import com.homework2.secondhomework.entity.Course;
import com.homework2.secondhomework.entity.Student;
import com.homework2.secondhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course") // getAll course
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/course")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/Put/course")
    public Course updateStudent(@RequestBody Course course){

        return courseService.update(course);
    }

    @DeleteMapping("/Delete/course/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return "Deleted...";
    }

    @DeleteMapping("/Delete/course") //object remove
    public String deleteCourse(@RequestBody Course course){
        courseService.delete(course);
        return "Deleted...";
    }

}
