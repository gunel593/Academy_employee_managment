package com.example.Academy_employee_managment.service.Impl;

import com.example.Academy_employee_managment.mapper.EmployeeMapper;
import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
import com.example.Academy_employee_managment.model.entity.Employee;
import com.example.Academy_employee_managment.mybatis.EmployeeMyBatis;
import com.example.Academy_employee_managment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeMyBatis employeeMyBatis;

    @Override
    public List<EmployeeResponse> empGetAll() {
        List<EmpWrapper>empWrapperList=employeeMyBatis.getAllEmp();
      List<EmployeeResponse> employeeResponseList =employeeMapper.toEmployeeResponceList(empWrapperList);
            return employeeResponseList;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long employeeId) {
        EmpWrapper empWrapper=employeeMyBatis.getEmployeeById(employeeId);
        return employeeMapper.toempResponce(empWrapper);

      //  return employeeOptional.map(employeeMapper::toempResponce).orElse(null);
    }

    @Override
    public void saveEmp(EmployeeRequest employeeRequest) {
        log.info("Insert received.EmployeeRequest:{}", employeeRequest);
        Employee employees=employeeMapper.toEmployee(employeeRequest);
        log.info("employeeMapper mapped to to Employee.employee:{}",employees);
            employeeMyBatis.saveEmp(employees);
        log.info("Add process was succesfull.");
        log.warn("Just warning{}", employeeRequest);
        log.error("Just error.{}", employeeRequest);
    }

//    @Override
//    public boolean statusEmp(boolean status) {
//        return false;
//    }

    @Override
    public void editEmp(Long employeeId, EmployeeRequest employeeRequest) {
        Employee employees=employeeMapper.toEmployeeByID(employeeId, employeeRequest);
           employeeMyBatis.editEmp(employees);
    }

    @Override
    public void deleteEmp(Long employeeId) {
        employeeMyBatis.deleteEmp(employeeId);
    }
}
