package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.LoginRequest;
import com.example.Academy_employee_managment.model.dto.request.UserRequest;
import com.example.Academy_employee_managment.model.dto.responce.LoginResponce;
import com.example.Academy_employee_managment.model.dto.responce.UserResponce;
import com.example.Academy_employee_managment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponce> register(@RequestBody UserRequest userRequest){
        UserResponce userResponce = userService.register(userRequest);
        return ResponseEntity.ok(userResponce);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponce>login(@RequestBody LoginRequest loginRequest){
        LoginResponce loginResponce=userService.login(loginRequest);
        return ResponseEntity.ok(loginResponce);
    }
}
