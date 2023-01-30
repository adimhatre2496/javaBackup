package com.example.springsecure.controller;

import com.example.springsecure.model.Student;
import com.example.springsecure.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student =studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.FOUND);
    }
}
