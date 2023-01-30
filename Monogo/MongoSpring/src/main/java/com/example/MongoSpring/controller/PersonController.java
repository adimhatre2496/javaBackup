package com.example.MongoSpring.controller;

import com.example.MongoSpring.model.Person;
import com.example.MongoSpring.service.PersonService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(Person person) {
        person = personService.createPerson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
