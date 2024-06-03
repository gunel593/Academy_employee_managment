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
public class EmployeeRequest {
    //private String employeeId;
    private String empName;
    private String empSurname;
    private String empEmail;
    private Integer status;
    private Long departmentId;
    private Long positionId;
    private LocalDateTime empCreatedAt;
    private LocalDateTime empUpdatedAt;

}
