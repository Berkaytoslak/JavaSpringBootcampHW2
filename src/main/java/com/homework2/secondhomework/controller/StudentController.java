package com.homework2.secondhomework.controller;

import com.homework2.secondhomework.entity.Student;
import com.homework2.secondhomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student") // getAll students
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/Put/student")
    public Student updateStudent(@RequestBody Student student){

        return studentService.update(student);
    }

    @DeleteMapping("/Delete/student/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Deleted...";
    }

    @DeleteMapping("/Delete/student") //object remove
    public String deleteStudent(@RequestBody Student student){
        studentService.delete(student);
        return "Deleted...";
    }

}
