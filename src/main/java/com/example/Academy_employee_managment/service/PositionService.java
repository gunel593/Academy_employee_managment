package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.PositionRequest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponse;

import java.util.List;

public interface PositionService {
    List<PositionResponse> posGetAll();
    PositionResponse getPositionById(Long positionId);
    void savePos(PositionRequest positionRequest);
    void editPos(Long positionId, PositionRequest positionRequest);
    void deletePos(Long positionId);
}
