package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface DepartmentMapper {
    //DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    List<DepartmentResponce>toDepartmentResponceList (List<Department>departmentList);
    DepartmentResponce todepResponce(Department department);
    @Mapping(target = "depCreatedAtDep", expression = "java(LocalDateTime.now())")
    Department toDepartment (DepartmentRequest departmentRequest);
    @Mapping(target = "depUpdatedAt", expression = "java(LocalDateTime.now())")
    Department toDepartmentByID (Long departmentId,DepartmentRequest departmentRequest);

}
