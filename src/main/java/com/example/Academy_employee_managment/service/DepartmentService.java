package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> depGetAll();
    DepartmentResponse getDepartmentById(Long departmentId);
    void saveDep(DepartmentRequest departmentRequest);
    void editDep(Long departmentId, DepartmentRequest departmentRequest);
    void deleteDep(Long departmentId);


}
