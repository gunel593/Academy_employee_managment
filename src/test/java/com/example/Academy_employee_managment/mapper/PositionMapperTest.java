package com.example.Academy_employee_managment.mapper;

import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
import com.example.Academy_employee_managment.model.dto.wrapper.Wrapper;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Position;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class PositionMapperTest {
    @Autowired
    private PositionMapper positionMapper;

    @Test
    public void testPositionMapper() {
          Wrapper wrapper = Wrapper
                  .builder()
                  .positionId(1L)
                  .positionName("Proqramist")
                  .salary(18000L)
                  .build();

        PositionResponse expected =
                PositionResponse
                        .builder()
                        .positionId(1L)
                        .positionName("Proqramist")
                        .salary(18000L)
                        .department(new Department())
                        .build();
        PositionResponse actual = positionMapper.toposResponce(wrapper);
        assertEquals(expected, actual);
    }
}
