package com.homework2.secondhomework.repository;

import com.homework2.secondhomework.entity.Course;
import com.homework2.secondhomework.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorJPAIMP implements InstructorDAO<Instructor>{

    private EntityManager entityManager;

    @Autowired
    public InstructorJPAIMP(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Instructor instructor = this.findById(id);
        entityManager.remove(instructor);
    }
    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    @Override
    public void delete(Instructor instructor) {
        entityManager.remove(instructor);
    }


}
