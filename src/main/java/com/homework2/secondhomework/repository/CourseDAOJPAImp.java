package com.homework2.secondhomework.repository;

import com.homework2.secondhomework.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImp implements CourseDAO<Course>{

    private EntityManager entityManager;

    @Autowired
    public CourseDAOJPAImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        return entityManager.createQuery("FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Course course = this.findById(id);
        entityManager.remove(course);

    }

    @Override
    @Transactional
    public Course update(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void delete(Course course) {
        entityManager.remove(course);
    }


}
