package com.example.AnimeCascade.service;

import com.example.AnimeCascade.entity.AddressEntity;
import com.example.AnimeCascade.entity.PersonEntity;
import com.example.AnimeCascade.model.Address;
import com.example.AnimeCascade.model.Person;
import com.example.AnimeCascade.model.PersonResponse;
import com.example.AnimeCascade.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {

    @Autowired
    private PersonRepository repository;
    public PersonResponse createPerson(Person person)
    {
        PersonEntity personEntity =new PersonEntity();
        AddressEntity addressEntity =new AddressEntity();

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());

        addressEntity.setAddress1(person.getAddress().getAddress1());
        addressEntity.setAddress2(person.getAddress().getAddress2());
        addressEntity.setCity(person.getAddress().getCity());
        addressEntity.setZipCode(person.getAddress().getZipCode());

        personEntity.setAddress(addressEntity);

        repository.save(personEntity);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());

        log.info("Entered Posted With Id "+ personResponse);
        log.info(personEntity.getId());
        log.info(addressEntity.getAddressId());

        return  personResponse;

    }

    public Person getPersonById(Long id)
    {
        Optional<PersonEntity>personEntityOptional=repository.findById(id);
        Person person=new Person();
        Address address=new Address();

        if(personEntityOptional.isPresent())
        {
            AddressEntity addressEntity = personEntityOptional.get().getAddress();
            PersonEntity personEntity = personEntityOptional.get();

            person.setFirstName(personEntity.getFirstName());
            person.setLastName(personEntity.getLastName());

            address.setAddress1(addressEntity.getAddress1());
            address.setAddress2(addressEntity.getAddress2());
            address.setCity(addressEntity.getCity());
            address.setZipCode(addressEntity.getZipCode());

            person.setAddress(address);

            log.info("ID Found "+ id);

        }
        else
        {
            log.info("Id Not Found");
        }

        return person;

    }

    public Person updatePerson(Long id, Person person)
    {
        Optional<PersonEntity>personEntityOptional=repository.findById(id);

        if (personEntityOptional.isPresent())
        {
            PersonEntity personEntity=personEntityOptional.get();
            AddressEntity addressEntity=new AddressEntity();
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());

            addressEntity.setAddress1(person.getAddress().getAddress1());
            addressEntity.setAddress2(person.getAddress().getAddress2());
            addressEntity.setCity(person.getAddress().getCity());
            addressEntity.setZipCode(person.getAddress().getZipCode());

            personEntity.setAddress(addressEntity);

            repository.save(personEntity);
            log.info("Updating...");
        }
        else
        {
          log.info("Update Error");
        }
        return person;
    }

    public void deleteById(Long id)
    {

        repository.deleteById(id);
    }
}
