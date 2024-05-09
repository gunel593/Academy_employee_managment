package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.EmployeeResquest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponce;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponce> empGetAll();
    EmployeeResponce empgetOne(Long employeeId);
    void saveEmp(EmployeeResquest employeeResquest);
    void editEmp(Long employeeId,EmployeeResquest employeeResquest);
    void deleteEmp(Long employeeId);
}
