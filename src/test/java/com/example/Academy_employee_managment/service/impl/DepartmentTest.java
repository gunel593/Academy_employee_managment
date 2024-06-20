package com.example.Academy_employee_managment.service.impl;

import com.example.Academy_employee_managment.mapper.DepartmentMapper;
import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.mybatis.DepartmentMyBatis;
import com.example.Academy_employee_managment.service.Impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DepartmentTest {
    @Mock
    private DepartmentMyBatis departmentMyBatis;

    @InjectMocks//ici dolu olanda bu test olur
    private DepartmentServiceImpl departmentServiceImpl;
    @Mock
    private DepartmentMapper departmentMapper;

    @Test
    void getAllDep_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-03-27 10:15:30", formatter);
        Department tests = Department.builder().departmentId(1L).depName("Security").build();
        List<Department> departmentList = List.of(tests);

        DepartmentResponse departmentResponse =
                DepartmentResponse.builder().departmentId(1L).depName("Security").depCreatedAt(dateTime).build();
        List<DepartmentResponse> excepted = List.of(departmentResponse);
        List<DepartmentResponse> wrongExpected = List.of();

        //when
        when(departmentMyBatis.getAllDep()).thenReturn(departmentList);
        when(departmentMapper.toDepartmentResponceList(departmentList)).thenReturn(excepted);

        //then/////////////
        List<DepartmentResponse> actual = departmentServiceImpl.depGetAll();
        assertEquals(excepted, actual);
        verify(departmentMyBatis, times(1)).getAllDep();
        verify(departmentMapper, times(1)).toDepartmentResponceList(departmentList);
        verifyNoMoreInteractions(departmentMapper, departmentMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getByIdDep_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-03-27 10:15:30", formatter);
        Department tests = Department.builder().departmentId(1L).depName("Security").build();
        Optional<Department> departmentOptional = Optional.of(tests);

        DepartmentResponse departmentResponse =
                DepartmentResponse.builder().departmentId(1L).depName("Security")
                        .depCreatedAt(dateTime).build();
        DepartmentResponse excepted = new DepartmentResponse();
        //List<DepartmentResponse>wrongExpected=List.of();

        //when
        when(departmentMyBatis.getDepartmentById(departmentResponse.getDepartmentId())).thenReturn(departmentOptional);
        when(departmentMapper.todepResponce(tests)).thenReturn(departmentResponse);

        //then/////////////
        DepartmentResponse actual = departmentServiceImpl.getDepartmentById(departmentResponse.getDepartmentId());
        assertEquals(excepted, actual);
        verify(departmentMyBatis, times(1)).getDepartmentById(departmentResponse.getDepartmentId());
        verify(departmentMapper, times(1)).todepResponce(tests);
        verifyNoMoreInteractions(departmentMapper, departmentMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getAddDeP_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Department test= Department.builder().departmentId(1L).depName("Security").build();
               DepartmentRequest departmentRequest=
                DepartmentRequest.builder().depName("Security")
                        .depCreatedAt(dateTime).build();
               //when
        doNothing().when(departmentMyBatis).saveDep(test);
        when(departmentMapper.toDepartment(departmentRequest)).thenReturn(test);

        //then/////////////
       departmentServiceImpl.saveDep(departmentRequest);

        verify(departmentMyBatis,times(1)).saveDep(test);
        verify(departmentMapper,times(1)).toDepartment(departmentRequest);
        verifyNoMoreInteractions(departmentMapper,departmentMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getEditDep_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Department test= Department.builder().departmentId(1L).depName("Security").build();
        DepartmentRequest departmentRequest=
                DepartmentRequest.builder().depName("Security")
                        .depCreatedAt(dateTime).build();
        //when
        doNothing().when(departmentMyBatis).editDep(test);
        when(departmentMapper.toDepartmentByID(test.getDepartmentId(),departmentRequest)).thenReturn(test);

        //then/////////////
        departmentServiceImpl.editDep(test.getDepartmentId(),departmentRequest);

        verify(departmentMyBatis,times(1)).editDep(test);
        verify(departmentMapper,times(1)).toDepartmentByID(test.getDepartmentId(),departmentRequest);
        verifyNoMoreInteractions(departmentMapper,departmentMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }
    void get_deleteDepSuccess(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Department test= Department.builder().departmentId(1L).depName("Security").build();
        //when
        doNothing().when(departmentMyBatis).deleteDep(test.getDepartmentId());
        //then/////////////
        departmentServiceImpl.deleteDep(test.getDepartmentId());

        verify(departmentMyBatis,times(1)).deleteDep(test.getDepartmentId());
        verifyNoMoreInteractions(departmentMapper,departmentMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }
}