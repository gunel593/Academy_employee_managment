package com.example.Academy_employee_managment.model.dto.responce;

import com.example.Academy_employee_managment.model.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PositionResponce {
    private Long positionId;
    private String positionName;
    private Long salary;
    private Department departmentId;
    private LocalDateTime posCreatedAtDep;
    private LocalDateTime posUpdatedAt;
    public PositionResponce(Department departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }
}