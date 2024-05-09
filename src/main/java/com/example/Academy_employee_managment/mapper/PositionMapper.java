package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.EmployeeResquest;
import com.example.Academy_employee_managment.model.dto.request.PositionResquest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponce;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponce;
import com.example.Academy_employee_managment.model.entity.Employee;
import com.example.Academy_employee_managment.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
    List<PositionResponce> toPositionResponceList (List<Position>positionList);
    PositionResponce toposResponce(Position position);
    Position toPosition(PositionResquest positionResquest);
    Position toPositionByID (Long positionId,PositionResquest positionResquest);
}
