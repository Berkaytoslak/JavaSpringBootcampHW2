package com.homework2.secondhomework.service;

import com.homework2.secondhomework.entity.Course;
import com.homework2.secondhomework.entity.Instructor;
import com.homework2.secondhomework.repository.InstructorDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor>{

    private InstructorDAO instructorDAO;

    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) instructorDAO.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDAO.update(instructor);
    }

    @Override
    public void delete(Instructor instructor) {
        instructorDAO.delete(instructor);
    }


}
