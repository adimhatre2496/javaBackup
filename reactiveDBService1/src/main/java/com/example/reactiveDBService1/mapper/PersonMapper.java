package com.example.reactiveDBService1.mapper;

import com.example.reactiveDBService1.entity.PersonEntity;
import com.example.reactiveDBService1.model.PersonRequest;
import org.mapstruct.Mapper;
import reactor.core.publisher.Mono;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper
    {
         PersonEntity modelToEntity(PersonRequest person);

         PersonRequest entityToModel(Mono<PersonEntity> personEntity);

         List<PersonRequest> entityToModels(List<PersonEntity> personEntities);

    }
