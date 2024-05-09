package com.example.Academy_employee_managment.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDateTime userCreatedAt;
    private LocalDateTime userUpdatedAt;
}
