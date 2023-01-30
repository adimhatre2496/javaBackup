package com.example.Cascade.mapper;

import com.example.Cascade.entity.AddressEntity;
import com.example.Cascade.entity.PersonEntity;
import com.example.Cascade.model.Address;
import com.example.Cascade.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonAddressMapper {
    PersonAddressMapper INSTANCE= Mappers.getMapper(PersonAddressMapper.class);

    PersonEntity personToEntity(Person person);
    AddressEntity personToEntity(Address address);

    Person entityToPerson(PersonEntity personEntity);
}
