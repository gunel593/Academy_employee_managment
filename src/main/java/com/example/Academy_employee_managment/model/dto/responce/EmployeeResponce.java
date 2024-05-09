package com.example.Academy_employee_managment.model.dto.responce;

import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponce {
    private String employeeId;
    private String empName;
    private String empSurname;
    private String empEmail;
    private Integer status;
    private Department departmentId;
    private Position positionId;
    private LocalDateTime empCreatedAt;
    private LocalDateTime empUpdatedAt;
}
