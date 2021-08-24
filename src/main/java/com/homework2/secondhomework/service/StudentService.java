package com.homework2.secondhomework.service;

import com.homework2.secondhomework.entity.Student;
import com.homework2.secondhomework.repository.StudentDAO;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements BaseService<Student>{

    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override // tüm bilgiler gelir
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override //id kullanarak listeleme
    public Student findById(int id) {
        return (Student) studentDAO.findById(id);
    }

    @Override
    @Transactional //save metodu
    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    @Override //silme metodu
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    @Override //güncelleme methodu
    public Student update(Student student) {
        return (Student) studentDAO.update(student);
    }

    @Override
    public void delete(Student student) {
        studentDAO.delete(student);
    }


}
