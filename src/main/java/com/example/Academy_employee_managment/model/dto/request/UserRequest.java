package com.example.Academy_employee_managment.model.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String userId;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String confirmPassword;
}
