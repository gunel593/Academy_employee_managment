package com.example.Academy_employee_managment.model.dto.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wrapper {
    private Long positionId;
    private String positionName;
    private Long salary;
    private LocalDateTime posCreatedAt;
    private LocalDateTime posUpdatedAt;
    //department in fielder
    private Long departmentId;
    private String depName;
    private LocalDateTime depCreatedAt;
    private LocalDateTime depUpdatedAt;

}
