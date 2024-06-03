package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.UserRequest;
import com.example.Academy_employee_managment.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring",imports={LocalDateTime.class})
public interface UserMapper {

    @Mapping(target = "createdAt",expression = "java(LocalDateTime.now())")
      User toUser(UserRequest userRequest);
}
