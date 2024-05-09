package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.PositionResquest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponce;

import java.util.List;

public interface PositionService {
    List<PositionResponce> posGetAll();
    PositionResponce getOnePos(Long positionId);
    void savePos(PositionResquest positionResquest);
    void editPos(Long positionId,PositionResquest positionResquest);
    void deletePos(Long positionId);
}
