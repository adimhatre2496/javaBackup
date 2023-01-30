package com.example.power.Controller;

import com.example.power.Model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class StudentController {
    @GetMapping(path = "/students/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Student> getStudent(@PathVariable long studentId)

    {

        Student student = new Student("Aditya", "Mhatre");
//        Student student1 = new Student("Raj", "Mhatre", "16/02/2000", 5023699, "Kisan", "Thane", 400604);
//        student.getFirstName();
//        student.getLastName();
//        student.getDateOfBirth();
//        student.getMobileNo();
//        student.getAddress();
//        student.getCity();
//        student.getPostalCode();
//
//        student1.getFirstName();
//        student1.getLastName();
//        student1.getDateOfBirth();
//        student1.getMobileNo();
//        student1.getAddress();
//        student1.getCity();
//        student1.getPostalCode();

        return new ResponseEntity<>(student, HttpStatus.OK);

    }
}
