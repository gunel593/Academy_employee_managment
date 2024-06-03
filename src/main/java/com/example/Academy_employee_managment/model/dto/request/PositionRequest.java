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
public class PositionRequest {
    //private Long positionId;
    private String positionName;
    private Long salary;
    private Long departmentId;
    private LocalDateTime posCreatedAt;
   private LocalDateTime posUpdatedAt;

}
