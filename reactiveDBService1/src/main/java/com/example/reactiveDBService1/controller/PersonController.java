package com.example.reactiveDBService1.controller;

import com.example.reactiveDBService1.entity.PersonEntity;
import com.example.reactiveDBService1.model.PersonRequest;
import com.example.reactiveDBService1.model.PersonResponse;
import com.example.reactiveDBService1.service.PersonService;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PersonController
    {
        public final PersonService personService;

//        @PostMapping(path = "/persons")
//        public Mono<PersonResponse> createRecords(@RequestBody PersonRequest personRequest)
//        {
//            PersonResponse personResponse= personService.createPerson(personRequest);
//            return Mono.just(PersonResponse.builder().build());
//
//            return personService.addPerson(personRequest);
//        }

        @PostMapping("/persons")
        public Mono<PersonEntity> addPerson(@RequestBody PersonRequest person) {
            log.info("start inserting");
            return personService.addPerson(person);
        }

        @GetMapping("/persons/{id}")
        public Mono<PersonEntity> getById(@PathVariable Long id) {
            log.info("start getting by id");
            return personService.getById(id);
        }

        @GetMapping("/persons")
        public Flux<PersonEntity> getAllPerson() {
            log.info("start getting all");
            return personService.getAllPerson();
        }
        //    @PutMapping("/persons/{id}")
//    public Mono<PersonEntity> updatePerson(@PathVariable Long id, @RequestBody Mono<PersonEntity> person) {
//        return personService.updatePerson(id, person);
//    }

        @DeleteMapping("/persons/{id}")
        public Mono<Void> deletePerson(@PathVariable Long id) {
            log.info("start deleting");
            return personService.deletePerson(id);
        }


    }
