package com.example.AnimeCascade.controller;

import com.example.AnimeCascade.model.Person;
import com.example.AnimeCascade.model.PersonResponse;
import com.example.AnimeCascade.service.PersonAddressService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
public class PersonController {

    @Autowired
    private PersonAddressService personAddressService;

    @PostMapping(path="/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person)
    {
        PersonResponse personResponse= personAddressService.createPerson(person);
        log.info("Post Successfully");
        return new ResponseEntity<>(personResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonById(@PathVariable Long id)
    {
        Person person = personAddressService.getPersonById(id);
        log.info("Person Id Found");
        return new  ResponseEntity<>(person,HttpStatus.OK);
    }

    @PutMapping(path = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person )
    {
        person=personAddressService.updatePerson(id, person);
        log.info("Update Successfully");

        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @DeleteMapping(path = "/persons/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id)
    {
      personAddressService.deleteById(id);
      log.info("Deleted Succesfully");
      return ResponseEntity.ok().build();
    }

}
