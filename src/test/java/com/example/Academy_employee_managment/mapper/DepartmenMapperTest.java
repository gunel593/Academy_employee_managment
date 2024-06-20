package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;
import com.example.Academy_employee_managment.model.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class DepartmenMapperTest {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Test
    public void testDepartmentMapper() {
        Department department = Department
                .builder()
                .departmentId(1L)
                .depName("IT")
                .build();
        DepartmentResponse expected = DepartmentResponse
                .builder()
                .departmentId(1L)
                .depName("IT")
                .build();
        DepartmentResponse actual = departmentMapper.todepResponce(department);
        assertEquals(expected, actual);
    }
}
