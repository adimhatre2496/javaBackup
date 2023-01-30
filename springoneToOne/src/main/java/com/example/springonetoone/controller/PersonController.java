package com.example.springonetoone.controller;

import com.example.springonetoone.model.Person;
import com.example.springonetoone.model.PersonResponse;
import com.example.springonetoone.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person) {
        PersonResponse personResponse = personService.createPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/person/{personId}")
    public ResponseEntity<Person> getByPersonId(@PathVariable Long personId) {
        Person person = personService.getById(personId);
        return new ResponseEntity<>(person, HttpStatus.OK);

    }}
