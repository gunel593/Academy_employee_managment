package com.example.Academy_employee_managment.mybatis;

import com.example.Academy_employee_managment.model.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;
@Mapper
public interface DepartmentMyBatis {
    List<Department>getAllDep();
    Optional<Department>getOneDep(@Param("departmentId")Long departmentId);
    void saveDep(Department department);
    void editDep(Department department);
    void deleteDep(@Param("departmentId")Long departmentId);
}
