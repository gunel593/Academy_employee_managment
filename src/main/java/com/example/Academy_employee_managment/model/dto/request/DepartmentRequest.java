package com.example.Academy_employee_managment.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentRequest {
    private Long departmentId;
    private String depName;
    private LocalDateTime depCreatedAtDep;
    private LocalDateTime depUpdatedAt;
}
