package com.example.springonetoone.service;

import com.example.springonetoone.entity.AddressEntity;
import com.example.springonetoone.entity.PersonEntity;
import com.example.springonetoone.model.Address;
import com.example.springonetoone.model.Person;
import com.example.springonetoone.model.PersonResponse;
import com.example.springonetoone.repository.AddressRepository;
import com.example.springonetoone.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public PersonService(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }

    public PersonResponse createPerson(Person person) {


        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setState(person.getAddress().getState());
        addressEntity.setZipCode(person.getAddress().getZipCode());
        addressRepository.save(addressEntity);
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(addressEntity);
        personRepository.save(personEntity);
        PersonResponse personResponse = new PersonResponse();
        personResponse.setPersonId(personEntity.getPersonId());
        return personResponse;
    }

  /*  public Person getById(Long personId) {
        Person person = new Person();
        Optional<PersonEntity> personEntity = personRepository.findById(personId);


    }*/
}



