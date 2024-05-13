package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.EmployeeResquest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring", imports = {LocalDateTime.class})
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    List<EmployeeResponce> toEmployeeResponceList (List<Employee>employeeList);
    EmployeeResponce toempResponce(Employee employee);
    @Mapping(target = "empCreatedAt", expression = "java(LocalDateTime.now())")
    Employee toEmployee (EmployeeResquest employeeResquest);
    @Mapping(target = "empUpdatedAt", expression = "java(LocalDateTime.now())")
    Employee toEmployeeByID (Long employeeId,EmployeeResquest employeeResquest);

}
