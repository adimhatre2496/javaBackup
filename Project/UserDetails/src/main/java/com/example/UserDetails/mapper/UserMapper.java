package com.example.UserDetails.mapper;

import com.example.UserDetails.entity.UserEntity;
import com.example.UserDetails.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper
    {
        UserEntity modelToEntity (UserModel userModel);

        UserModel entityToModel (UserEntity userEntity);
    }
