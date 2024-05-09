package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.EmployeeResquest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    List<EmployeeResponce> toEmployeeResponceList (List<Employee>employeeList);
    EmployeeResponce toempResponce(Employee employee);
    Employee toEmployee (EmployeeResquest employeeResquest);
    Employee toEmployeeByID (Long employeeId,EmployeeResquest employeeResquest);

}
