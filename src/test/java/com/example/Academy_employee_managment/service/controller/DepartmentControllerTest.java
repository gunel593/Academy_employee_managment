package com.example.Academy_employee_managment.service.controller;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
@WebMvcTest(controllers = DepartmentControllerTest.class)
@WithMockUser(username = "user",password = "pass")
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean(name = "departmentServiceImpl")
    private DepartmentService departmentService;
    @Test
    private void testGetallDepartment_Success() throws Exception {
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setDepartmentId(2L);
        List<DepartmentResponse> departmentResponseList = List.of(departmentResponse);

        DepartmentResponse.builder().departmentId(2L).depName("Security").build();

        //given

        //when
        when(departmentService.depGetAll()).thenReturn(departmentResponseList);
        ///then
        mockMvc.perform(get("/department/no-auth")
        )
              .andExpect(jsonPath("$.[0].departmentId", is(2))
              )    .andExpect(status().isOk());
    }
    @Test
    private void testGetByIdDepartment_Success() throws Exception {
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setDepartmentId(2L);
        List<DepartmentResponse> departmentResponseList = List.of(departmentResponse);

        DepartmentResponse.builder().departmentId(2L).depName("Security").build();

        //given

        //when
        when(departmentService.getDepartmentById(departmentResponse.getDepartmentId()))
                .thenReturn((DepartmentResponse) departmentResponseList);
        ///then
        mockMvc.perform(get("/department/no-auth")
                )
                .andExpect(jsonPath("$.[0].departmentId", is(2))
                )    .andExpect(status().isOk());
    }
    @Test
    private void testAddDepartment_Success() throws Exception {
        DepartmentRequest departmentRequest=DepartmentRequest.builder().depName("IT").build();
       doNothing().when(departmentService).saveDep(departmentRequest);
        ///then
        mockMvc.perform(post("/department")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(departmentRequest))
                )
                //  .andExpect(jsonPath("$.[0].departmentId",is(2)))
                .andExpect(status().isOk());
    }
    @Test
    private void testInsertDepartment_Success() throws Exception {
        Department department= Department.builder().departmentId(1L).build();
        DepartmentRequest departmentRequest=DepartmentRequest.builder().depName("IT").build();
        doNothing().when(departmentService).editDep(department.getDepartmentId(),departmentRequest);
        mockMvc.perform(put("/department")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(department.getDepartmentId()))
                )
                //  .andExpect(jsonPath("$.[0].departmentId",is(2)))
                .andExpect(status().isOk());
    }
    @Test
    private void testDeleteDepartment_Success() throws Exception {
        Department department= Department.builder().departmentId(1L).build();
        DepartmentRequest departmentRequest=DepartmentRequest.builder().depName("IT").build();
        doNothing().when(departmentService).deleteDep(department.getDepartmentId());
        mockMvc.perform(delete("/department")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(objectMapper.writeValueAsString(department.getDepartmentId()))
                )
                //  .andExpect(jsonPath("$.[0].departmentId",is(2)))
                .andExpect(status().isOk());
    }
}
