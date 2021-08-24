package com.homework2.secondhomework.controller;


import com.homework2.secondhomework.entity.Course;
import com.homework2.secondhomework.entity.Instructor;
import com.homework2.secondhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructor") // getAll instructor
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/instructor")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @GetMapping("/instructor/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/Put/instructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }

    @DeleteMapping("/Delete/instructor/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Deleted...";
    }

    @DeleteMapping("/Delete/instructor") //object remove
    public String deleteInstructor(@RequestBody Instructor instructor){
        instructorService.delete(instructor);
        return "Deleted...";
    }


}
