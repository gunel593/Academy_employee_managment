package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Position;
import com.example.Academy_employee_managment.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = EmployeeControllerTest.class)
@WithMockUser(username = "user",password = "pass")
public class EmployeeControllerTest {
        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private ObjectMapper objectMapper;
        @MockBean(name = "EmployeeServiceImpl")
        private EmployeeService employeeService;
        @Test
        private void testGetallEmployee_Success() throws Exception {
            EmployeeResponse employeeResponse=new EmployeeResponse();
            employeeResponse.setEmployeeId(3L);
            List<EmployeeResponse> employeeResponseList = List.of(employeeResponse);

            EmployeeResponse
                    .builder()
                    .employeeId(2L)
                    .empName("Gunel")
                    .position(new Position())
                    .department(new Department())
                    .empSurname("Quluyeva")
                    .empEmail("fdjbfs@gmail.com")
                    .status(1)
                    .build();

//departmentin fieldlerini nece edek vede created at
            //given

            //when
            when(employeeService.empGetAll()).thenReturn(employeeResponseList);
            ///then
            mockMvc.perform(get("/employee/no-auth")
                    )
                    .andExpect(status().isOk());
        }
    @Test
    private void testAddEmployee_Success() throws Exception {
        EmployeeRequest employeeRequest=EmployeeRequest.builder() .empName("Gunel")
                .empSurname("Quluyeva").empEmail("fdjbfs@gmail.com")
                .status(1).build();
        doNothing().when(employeeService).saveEmp(employeeRequest);
        ///then
        mockMvc.perform(post("/employee")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(employeeRequest))
                )
                //  .andExpect(jsonPath("$.[0].departmentId",is(2)))
                .andExpect(status().isOk());
    }
    }

