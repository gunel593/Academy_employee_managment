package com.example.Academy_employee_managment.service.Impl;

import com.example.Academy_employee_managment.mapper.DepartmentMapper;
import com.example.Academy_employee_managment.mapper.EmployeeMapper;
import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.EmployeeResquest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponce;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Employee;
import com.example.Academy_employee_managment.mybatis.DepartmentMyBatis;
import com.example.Academy_employee_managment.mybatis.EmployeeMyBatis;
import com.example.Academy_employee_managment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeMyBatis employeeMyBatis;

    @Override
    public List<EmployeeResponce> empGetAll() {
        List<Employee>employees=employeeMyBatis.getAllEmp();
      List<EmployeeResponce> employeeResponceList=employeeMapper.toEmployeeResponceList(employees);
            return employeeResponceList;
    }

    @Override
    public EmployeeResponce getEmployeeById(Long employeeId) {
        Optional<Employee> employeeOptional=employeeMyBatis.getEmployeeById(employeeId);
        return employeeOptional.map(employeeMapper::toempResponce).orElse(null);
    }

    @Override
    public void saveEmp(EmployeeResquest employeeResquest) {
        log.info("Insert received.EmployeeResquest:{}",employeeResquest);
        Employee employees=employeeMapper.toEmployee(employeeResquest);
        log.info("employeeMapper mapped to to Employee.employee:{}",employees);
            employeeMyBatis.saveEmp(employees);
        log.info("Add process was succesfull.");
        log.warn("Just warning{}",employeeResquest);
        log.error("Just error.{}",employeeResquest);
    }

    @Override
    public void editEmp(Long employeeId, EmployeeResquest employeeResquest) {
        Employee employees=employeeMapper.toEmployeeByID(employeeId,employeeResquest);
           employeeMyBatis.editEmp(employees);
    }

    @Override
    public void deleteEmp(Long employeeId) {
        employeeMyBatis.deleteEmp(employeeId);
    }
}
