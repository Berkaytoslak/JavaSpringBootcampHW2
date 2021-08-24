package com.homework2.secondhomework.repository;

import com.homework2.secondhomework.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImp implements StudentDAO<Student>{


    private EntityManager entityManager;

    @Autowired
    public StudentDAOJPAImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() { // getAll Query
        return entityManager.createQuery("FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Student student = this.findById(id);
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public void delete(Student student) {
        entityManager.remove(student);
    }


}
