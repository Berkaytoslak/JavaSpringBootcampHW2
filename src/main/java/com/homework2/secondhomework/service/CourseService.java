package com.homework2.secondhomework.service;

import com.homework2.secondhomework.entity.Course;
import com.homework2.secondhomework.entity.Student;
import com.homework2.secondhomework.repository.CourseDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements BaseService<Course>{

    private CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {

        courseDAO.deleteById(id);

    }
    @Override
    public Course update(Course course) {
        return (Course) courseDAO.update(course);
    }

    @Override
    public void delete(Course course) {
        courseDAO.delete(course);
    }


}
