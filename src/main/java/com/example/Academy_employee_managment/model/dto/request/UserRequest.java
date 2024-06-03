package com.example.Academy_employee_managment.model.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String confirmPassword;
    private String name;
    private String surname;
}
