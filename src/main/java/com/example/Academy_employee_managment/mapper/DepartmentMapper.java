package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);
    List<DepartmentResponce>toDepartmentResponceList (List<Department>departmentList);
    DepartmentResponce todepResponce(Department department);
    Department toDepartment (DepartmentRequest departmentRequest);
    Department toDepartmentByID (Long departmentId,DepartmentRequest departmentRequest);

}
