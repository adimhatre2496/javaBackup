package com.example.MongoSpring.service;

import com.example.MongoSpring.document.PersonDocument;
import com.example.MongoSpring.model.Person;
import com.example.MongoSpring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PersonService
    {
        @Autowired
        private PersonRepository personRepository;

        public Person createPerson(Person person)
        {
            PersonDocument personDocument=new PersonDocument();
            personDocument.setId(person.getId());
            personDocument.setFirstName(person.getFirstName());
            personDocument.setLastName(person.getLastName());
            personRepository.save(personDocument);
            return person;
        }
    }
