package com.example.Academy_employee_managment.model.dto.wrapper;

import com.example.Academy_employee_managment.model.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConnectRapper {
    private Long positionId;
    private String positionName;
    private Long salary;
    private LocalDateTime posCreatedAtDep;
    private LocalDateTime posUpdatedAt;
    private Long departmentId;
    private String depName;
    private LocalDateTime depCreatedAtDep;
    private LocalDateTime depUpdatedAt;

}
