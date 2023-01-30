package com.example.reactiveDBService1.repository;

import com.example.reactiveDBService1.entity.PersonEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveCrudRepository<PersonEntity,Long> {
}
