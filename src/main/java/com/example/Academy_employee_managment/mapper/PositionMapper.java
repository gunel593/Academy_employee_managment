package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.PositionRequest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.Wrapper;
import com.example.Academy_employee_managment.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface PositionMapper {
   // PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
   // List<PositionResponse> toPositionResponceList (List<Position>positionList);
   @Mapping(target ="department.departmentId",source="departmentId")
   @Mapping(target ="department.depName",source="depName")
   @Mapping(target ="department.depCreatedAt",source="depCreatedAt")
   @Mapping(target ="department.depUpdatedAt",source="depUpdatedAt")
   PositionResponse toposResponce(Wrapper wrapper);
    @Mapping(target ="department.department",source="departmentId")
    @Mapping(target ="department.depName",source="depName")
    @Mapping(target ="department.depCreatedAt",source="depCreatedAt")
    @Mapping(target ="department.depUpdatedAt",source="depUpdatedAt")
    List<PositionResponse> topositionList(List<Wrapper> rapperList);
    @Mapping(target = "posCreatedAt", expression = "java(LocalDateTime.now())")
    Position toPosition(PositionRequest positionRequest);
    @Mapping(target = "posUpdatedAt", expression = "java(LocalDateTime.now())")
    Position toPositionByID (Long positionId, PositionRequest positionRequest);
}
