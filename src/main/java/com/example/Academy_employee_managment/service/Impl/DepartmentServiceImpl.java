package com.example.Academy_employee_managment.service.Impl;

import com.example.Academy_employee_managment.mapper.DepartmentMapper;
import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.mybatis.DepartmentMyBatis;
import com.example.Academy_employee_managment.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final DepartmentMyBatis departmentMyBatis;
    @Override
    public List<DepartmentResponce> depGetAll() {
     List<Department>departments=departmentMyBatis.getAllDep();
     List<DepartmentResponce> departmentResponceList=departmentMapper.toDepartmentResponceList(departments);
     return departmentResponceList;
    }

    @Override
    public DepartmentResponce depgetOne(Long departmentId) {
        Optional<Department>departmentOptional=departmentMyBatis.getOneDep(departmentId);
        return departmentOptional.map(departmentMapper::todepResponce).orElse(null);
    }

    @Override
    public void saveDep(DepartmentRequest departmentRequest) {
        log.info("Insert received.DepartmentRequest:{}",departmentRequest);
        Department departments=departmentMapper.toDepartment(departmentRequest);
        log.info("deparmentMapper mapped to to Department.department:{}",departments);
        departmentMyBatis.saveDep(departments);
        log.info("Add process was succesfull.");
        log.warn("Just warning{}",departmentRequest);
        log.error("Just error.{}",departmentRequest);
    }

    @Override
    public void editDep(Long departmentId, DepartmentRequest departmentRequest) {
        Department departments=departmentMapper.toDepartmentByID(departmentId,departmentRequest);
        departmentMyBatis.editDep(departments);
    }

    @Override
    public void deleteDep(Long departmentId) {
        departmentMyBatis.deleteDep(departmentId);

    }
}
