package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.PositionResquest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponce;
import com.example.Academy_employee_managment.model.dto.wrapper.ConnectRapper;
import com.example.Academy_employee_managment.model.entity.Position;

import java.util.List;

public interface PositionService {
    List<ConnectRapper> posGetAll();
    PositionResponce getPositionById(Long positionId);
    void savePos(PositionResquest positionResquest);
    void editPos(Long positionId,PositionResquest positionResquest);
    void deletePos(Long positionId);
}
