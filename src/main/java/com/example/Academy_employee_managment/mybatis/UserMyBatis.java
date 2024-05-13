package com.example.Academy_employee_managment.mybatis;

import com.example.Academy_employee_managment.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMyBatis {
    void insert(User user);
    Optional<User> findByUsername(@Param("username") String username);
}
