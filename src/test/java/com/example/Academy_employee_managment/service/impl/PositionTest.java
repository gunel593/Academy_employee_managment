package com.example.Academy_employee_managment.service.impl;

import com.example.Academy_employee_managment.mapper.EmployeeMapper;
import com.example.Academy_employee_managment.mapper.PositionMapper;
import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.request.PositionRequest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
import com.example.Academy_employee_managment.model.dto.wrapper.Wrapper;
import com.example.Academy_employee_managment.model.entity.Department;
import com.example.Academy_employee_managment.model.entity.Employee;
import com.example.Academy_employee_managment.model.entity.Position;
import com.example.Academy_employee_managment.mybatis.EmployeeMyBatis;
import com.example.Academy_employee_managment.mybatis.PositionMyBatis;
import com.example.Academy_employee_managment.service.Impl.EmployeeServiceImpl;
import com.example.Academy_employee_managment.service.Impl.PositionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class PositionTest {
    @Mock
    private PositionMyBatis positionMyBatis;

    @InjectMocks//ici dolu olanda bu test olur
    private PositionServiceImpl positionServiceImpl;
    @Mock
    private PositionMapper positionMapper;

    @Test
    void getAllPos_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-03-27 10:15:30", formatter);
        Wrapper tests = Wrapper
                .builder()
                .positionId(1L)
                .positionName("Proqramist")
                .salary(18000L)
                .build();
        List<Wrapper> wrapperList = List.of(tests);

        PositionResponse positionResponse =
                PositionResponse
                        .builder()
                        .positionId(1L)
                        .positionName("Proqramist")
                        .salary(18000L)
                        .department(new Department())
                        .build();
        List<PositionResponse> excepted = List.of(positionResponse);
        //when
        when(positionMyBatis.getAllPos()).thenReturn(wrapperList);
        when(positionMapper.topositionList(wrapperList)).thenReturn(excepted);

        //then/////////////
        List<PositionResponse> actual = positionServiceImpl.posGetAll();
        assertEquals(excepted, actual);
        verify(positionMyBatis, times(1)).getAllPos();
        verify(positionMapper, times(1)).topositionList(wrapperList);
        verifyNoMoreInteractions(positionMapper, positionMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getByIdPos_Success() {
        //given
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse("2019-03-27 10:15:30", formatter);
        Wrapper tests = Wrapper
                .builder()
                .positionId(1L)
                .positionName("Proqramist")
                .salary(18000L)
                .build();
        List<Wrapper> wrapperList = List.of(tests);

        PositionResponse positionResponse =
                PositionResponse
                        .builder()
                        .positionId(1L)
                        .positionName("Proqramist")
                        .salary(18000L)
                        .department(new Department())
                        .build();
        List<PositionResponse> excepted = List.of(positionResponse);
        //when
        when(positionMyBatis.getPositionById(positionResponse.getPositionId())).thenReturn(tests);
        when(positionMapper.toposResponce(tests)).thenReturn(positionResponse);

        //then/////////////
        PositionResponse actual = positionServiceImpl.getPositionById(positionResponse.getPositionId());
        assertEquals(excepted, actual);
        verify(positionMyBatis, times(1)).getPositionById(positionResponse.getPositionId());
        verify(positionMapper, times(1)).toposResponce(tests);
        verifyNoMoreInteractions(positionMapper, positionMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }

    void getAddPos_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
       Position test= Position
                .builder()
                .positionId(1L)
                .salary(18000L)
                .positionName("fdfbdjfb")
                .departmentId(1L)
                .build();
        PositionRequest positionRequest =
                PositionRequest
                        .builder()
                        .positionName("Proqramist")
                        .salary(18000L)
                        .departmentId(1L)
                        .build();
        //when
        doNothing().when(positionMyBatis).savePos(test);
        when(positionMapper.toPosition(positionRequest)).thenReturn(test);

        //then/////////////
        positionServiceImpl.savePos(positionRequest);

        verify(positionMyBatis,times(1)).savePos(test);
        verify(positionMapper,times(1)).toPosition(positionRequest);
        verifyNoMoreInteractions(positionMapper,positionMyBatis);
    }

    void getEditPos_Success(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Position test= Position
                .builder()
                .positionId(1L)
                .salary(18000L)
                .positionName("fdfbdjfb")
                .departmentId(1L)
                .build();
        PositionRequest positionRequest =
                PositionRequest
                        .builder()
                        .positionName("Proqramist")
                        .salary(18000L)
                        .departmentId(1L)
                        .build();
        //when
        doNothing().when(positionMyBatis).editPos(test);
        when(positionMapper.toPositionByID(test.getPositionId(),positionRequest)).thenReturn(test);

        //then/////////////
        positionServiceImpl.editPos(test.getPositionId(),positionRequest);

        verify(positionMyBatis,times(1)).editPos(test);
        verify(positionMapper,times(1)).toPositionByID(test.getPositionId(),positionRequest);
        verifyNoMoreInteractions(positionMapper,positionMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }
    void get_deletePosSuccess(){
        //given
        DateTimeFormatter formatter = DateTimeFormatter. ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime. parse("2019-03-27 10:15:30", formatter);
        Position test= Position
                .builder()
                .positionId(1L)
                .salary(18000L)
                .positionName("fdfbdjfb")
                .departmentId(1L)
                .build();
        //when
        doNothing().when(positionMyBatis).deletePos(test.getPositionId());
        //then/////////////
        positionServiceImpl.deletePos(test.getPositionId());

        verify(positionMyBatis,times(1)).deletePos(test.getPositionId());
        verifyNoMoreInteractions(positionMapper,positionMyBatis);
        //verifyNoInteractions(departmentMyBatis);
    }
}
