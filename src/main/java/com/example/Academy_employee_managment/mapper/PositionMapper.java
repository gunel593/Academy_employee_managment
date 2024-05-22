package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.PositionResquest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponce;
import com.example.Academy_employee_managment.model.dto.wrapper.ConnectRapper;
import com.example.Academy_employee_managment.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
   // List<PositionResponce> toPositionResponceList (List<Position>positionList);
    PositionResponce toposResponce(Position position);
    @Mapping(target ="department.departmentId",source="departmentId")
    @Mapping(target ="department.depName",source="depName")
    @Mapping(target ="department.depCreatedAtDep",source="depCreatedAtDep")
    @Mapping(target ="department.depUpdatedAt",source="depUpdatedAt")
     List<Position> topositionList(List<ConnectRapper> rapperList);
    @Mapping(target = "posCreatedAtDep", expression = "java(LocalDateTime.now())")
    Position toPosition(PositionResquest positionResquest);
    @Mapping(target = "posUpdatedAt", expression = "java(LocalDateTime.now())")
    Position toPositionByID (Long positionId,PositionResquest positionResquest);
}
