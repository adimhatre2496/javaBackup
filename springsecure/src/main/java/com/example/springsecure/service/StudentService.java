package com.example.springsecure.service;

import com.example.springsecure.model.Student;
import org.springframework.stereotype.Service;



import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private static final List<Student> student = Arrays.asList(
            new Student(1L,"Aditya"),
            new Student(2L,"Sunny"),
            new Student(3L,"Tzuyu")

    );


    public Student getStudentById(Long id) {
      return   student.stream().filter(student1 -> id == student1.getId())
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Student" + id));
    }
}
