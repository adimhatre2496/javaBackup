package com.example.MongoSpring.repository;

import com.example.MongoSpring.document.PersonDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<PersonDocument, Long>
    {

    }
