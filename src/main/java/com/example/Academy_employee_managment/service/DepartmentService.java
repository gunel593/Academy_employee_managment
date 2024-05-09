package com.example.Academy_employee_managment.service;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponce> depGetAll();
    DepartmentResponce depgetOne(Long Depatmentid);
    void saveDep(DepartmentRequest departmentRequest);
    void editDep(Long Depatmentid, DepartmentRequest departmentRequest);
    void deleteDep(Long Depatmentid);


}