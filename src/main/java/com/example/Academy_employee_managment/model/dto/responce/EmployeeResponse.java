package com.example.Academy_employee_managment.model.dto.responce;

import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Position;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
    private Long employeeId;
    private String empName;
    private String empSurname;
    private String empEmail;
    private Integer status;
    private Department department;
    private Position position;
    private LocalDateTime empCreatedAt;
    private LocalDateTime empUpdatedAt;

}
