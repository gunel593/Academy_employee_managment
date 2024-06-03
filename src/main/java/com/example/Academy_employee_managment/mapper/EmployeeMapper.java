package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
import com.example.Academy_employee_managment.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface EmployeeMapper {
    //EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    @Mapping(target ="department.departmentId",source="departmentId")
    @Mapping(target ="department.depName",source="depName")
    @Mapping(target ="department.depCreatedAt",source="depCreatedAt")
    @Mapping(target ="department.depUpdatedAt",source="depUpdatedAt")
    @Mapping(target ="position.positionId",source="positionId")
    @Mapping(target ="position.positionName",source="positionName")
    @Mapping(target ="position.salary",source="salary")
    @Mapping(target ="position.posCreatedAt",source="posCreatedAt")
    @Mapping(target ="position.posUpdatedAt",source="posUpdatedAt")
    List<EmployeeResponse> toEmployeeResponceList (List<EmpWrapper>wrapperList);

    @Mapping(target ="department.departmentId",source="departmentId")
    @Mapping(target ="department.depName",source="depName")
    @Mapping(target ="department.depCreatedAt",source="depCreatedAt")
    @Mapping(target ="department.depUpdatedAt",source="depUpdatedAt")
    @Mapping(target ="position.positionId",source="positionId")
    @Mapping(target ="position.positionName",source="positionName")
    @Mapping(target ="position.salary",source="salary")
    @Mapping(target ="position.posCreatedAt",source="posCreatedAt")
    @Mapping(target ="position.posUpdatedAt",source="posUpdatedAt")
    EmployeeResponse toempResponce(EmpWrapper empWrapper);

    @Mapping(target ="department.departmentId",source="departmentId")
    @Mapping(target ="position.positionId",source="positionId")
    @Mapping(target = "empCreatedAt", expression = "java(LocalDateTime.now())")
    Employee toEmployee (EmployeeRequest employeeRequest);

    @Mapping(target ="department.departmentId",source="employeeRequest.departmentId")
    @Mapping(target ="position.positionId",source="employeeRequest.positionId")
    @Mapping(target = "empUpdatedAt", expression = "java(LocalDateTime.now())")
    Employee toEmployeeByID (Long employeeId, EmployeeRequest employeeRequest);

}
