package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> empGetAll();
    EmployeeResponse getEmployeeById(Long employeeId);
    void saveEmp(EmployeeRequest employeeRequest);
//    boolean statusEmp(boolean status);
    void editEmp(Long employeeId, EmployeeRequest employeeRequest);
    void deleteEmp(Long employeeId);
}
