package com.example.MongoSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person
    {
        private Long id;
        private String firstName;
        private String lastName;
    }
