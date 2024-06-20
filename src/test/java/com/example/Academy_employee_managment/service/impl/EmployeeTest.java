package com.example.Academy_employee_managment.service.impl;

import com.example.Academy_employee_managment.mapper.DepartmentMapper;
import com.example.Academy_employee_managment.mapper.EmployeeMapper;
import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Employee;
import com.example.Academy_employee_managment.model.entity.Position;
import com.example.Academy_employee_managment.mybatis.DepartmentMyBatis;
import com.example.Academy_employee_managment.mybatis.EmployeeMyBatis;
import com.example.Academy_employee_managment.service.Impl.DepartmentServiceImpl;
import com.example.Academy_employee_managment.service.Impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class EmployeeTest {
    @Mock
    private EmployeeMyBatis employeeMyBatis;

    @InjectMocks//ici dolu olanda bu test olur
    private EmployeeServiceImpl employeeServiceImpl;
    @Mock
    private EmployeeMapper employeeMapper;

    @Test
    void getAllEmp_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-03-27 10:15:30", formatter);
        EmpWrapper tests = EmpWrapper
                .builder()
                .employeeId(1L)
                .empName("sghzdgf")
                .empSurname("sdcvbnu")
                .empEmail("cvfuby@gmail.com")
                .status(1)
                .build();
        List<EmpWrapper> employeeList = List.of(tests);

        EmployeeResponse employeeResponse =
                EmployeeResponse
                        .builder()
                        .empName("sghzdgf")
                        .empSurname("sdcvbnu")
                        .empEmail("cvfuby@gmail.com")
                        .status(1)
                        .position(new Position())
                        .department(new Department())
                        .build();
        List<EmployeeResponse> excepted = List.of(employeeResponse);
        //when
        when(employeeMyBatis.getAllEmp()).thenReturn(employeeList);
        when(employeeMapper.toEmployeeResponceList(employeeList)).thenReturn(excepted);

        //then/////////////
        List<EmployeeResponse> actual = employeeServiceImpl.empGetAll();
        assertEquals(excepted, actual);
        verify(employeeMyBatis, times(1)).getAllEmp();
        verify(employeeMapper, times(1)).toEmployeeResponceList(employeeList);
        verifyNoMoreInteractions(employeeMapper, employeeMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getByIdEmp_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-03-27 10:15:30", formatter);
        EmpWrapper tests = EmpWrapper
                .builder().employeeId(1L)
                .empName("sghzdgf")
                .empSurname("sdcvbnu")
                .empEmail("cvfuby@gmail.com")
                .status(1)
                .build();
        List<EmpWrapper> employeeList = List.of(tests);

        EmployeeResponse employeeResponse =
                EmployeeResponse
                        .builder()
                        .empName("sghzdgf")
                        .empSurname("sdcvbnu")
                        .empEmail("cvfuby@gmail.com")
                        .status(1)
                        .position(new Position())
                        .department(new Department())
                        .build();
        List<EmployeeResponse> excepted = List.of(employeeResponse);
        //when
        when(employeeMyBatis.getEmployeeById(employeeResponse.getEmployeeId())).thenReturn(tests);
        when(employeeMapper.toempResponce(tests)).thenReturn(employeeResponse);

        //then/////////////
        EmployeeResponse actual = employeeServiceImpl.getEmployeeById(employeeResponse.getEmployeeId());
        assertEquals(excepted, actual);
        verify(employeeMyBatis, times(1)).getEmployeeById(employeeResponse.getEmployeeId());
        verify(employeeMapper, times(1)).toempResponce(tests);
        verifyNoMoreInteractions(employeeMapper, employeeMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getAddEmp_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Employee test= Employee
                .builder()
                .employeeId(1L)
                .empName("Gunel")
                .empSurname("Quluyeva")
                .status(1)
                .department(new Department())
                .position(new Position())
                .build();
        EmployeeRequest employeeRequest=
                EmployeeRequest.builder()
                        .empName("Gunel")
                        .empSurname("Quluyeva")
                        .status(1)
                        .departmentId(1L)
                        .positionId(1L)
                        .build();
        //when
        doNothing().when(employeeMyBatis).saveEmp(test);
        when(employeeMapper.toEmployee(employeeRequest)).thenReturn(test);

        //then/////////////
        employeeServiceImpl.saveEmp(employeeRequest);

        verify(employeeMyBatis,times(1)).saveEmp(test);
        verify(employeeMapper,times(1)).toEmployee(employeeRequest);
        verifyNoMoreInteractions(employeeMapper,employeeMyBatis);
    }

    void getEditEmp_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Employee test= Employee
                .builder()
                .employeeId(1L)
                .empName("Gunel")
                .empSurname("Quluyeva")
                .status(1)
                .department(new Department())
                .position(new Position())
                .build();
        EmployeeRequest employeeRequest=
                EmployeeRequest.builder()
                        .empName("Gunel")
                        .empSurname("Quluyeva")
                        .status(1)
                        .departmentId(1L)
                        .positionId(1L)
                        .build();
        //when
        doNothing().when(employeeMyBatis).editEmp(test);
        when(employeeMapper.toEmployeeByID(test.getEmployeeId(),employeeRequest)).thenReturn(test);

        //then/////////////
        employeeServiceImpl.editEmp(test.getEmployeeId(),employeeRequest);

        verify(employeeMyBatis,times(1)).editEmp(test);
        verify(employeeMapper,times(1)).toEmployeeByID(test.getEmployeeId(),employeeRequest);
        verifyNoMoreInteractions(employeeMapper,employeeMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }
    void get_deleteEmpSuccess(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Employee test= Employee
                .builder()
                .employeeId(1L)
                .empName("Gunel")
                .empSurname("Quluyeva")
                .status(1)
                .department(new Department())
                .position(new Position())
                .build();
        //when
        doNothing().when(employeeMyBatis).deleteEmp(test.getEmployeeId());
        //then/////////////
        employeeServiceImpl.deleteEmp(test.getEmployeeId());

        verify(employeeMyBatis,times(1)).deleteEmp(test.getEmployeeId());
        verifyNoMoreInteractions(employeeMapper,employeeMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }
}
