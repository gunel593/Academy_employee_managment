package com.example.Academy_employee_managment.mybatis;

import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMyBatis {
    List<EmpWrapper> getAllEmp();
    EmpWrapper getEmployeeById(@Param("employeeId")Long employeeId);
    void saveEmp(Employee employee);
  //  boolean statusEmp(boolean status);
    void editEmp(Employee employee);
    void deleteEmp(@Param("employeeId")Long employeeId);
}
