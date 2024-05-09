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
public class Department {

    private Long departmentId;
    private String depName;
    private LocalDateTime depCreatedAtDep;
    private LocalDateTime depUpdatedAt;
}
