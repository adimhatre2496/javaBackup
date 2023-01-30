package com.example.reactiveDBService1.service;

import com.example.reactiveDBService1.entity.PersonEntity;
import com.example.reactiveDBService1.mapper.PersonMapper;
import com.example.reactiveDBService1.model.PersonRequest;
import com.example.reactiveDBService1.model.PersonResponse;
import com.example.reactiveDBService1.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PersonService {

    public final PersonMapper personMapper;

    public final PersonRepository personRepository;

    public Mono<PersonEntity> addPerson(PersonRequest person) {
        PersonEntity personEntity = personMapper.modelToEntity(person);
        return personRepository.save(personEntity);

    }

    public Mono<PersonEntity> getById(Long id) {

        return personRepository.findById(id);

    }

    public Flux<PersonEntity> getAllPerson() {
        return personRepository.findAll();
    }

    public Mono<Void> deletePerson(Long id) {
        return personRepository.deleteById(id);
    }

//    public PersonResponse createPerson(PersonRequest personRequest) {
//        PersonEntity personEntity = personMapper.modelToEntity(personRequest);
//        personRepository.save(personEntity);
//        PersonResponse personResponse=new PersonResponse();
//        personResponse.setId(personEntity.getId());
//        return personResponse;
//
//    }
}
