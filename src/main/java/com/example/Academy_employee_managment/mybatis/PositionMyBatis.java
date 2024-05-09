package com.example.Academy_employee_managment.mybatis;

import com.example.Academy_employee_managment.model.entity.Employee;
import com.example.Academy_employee_managment.model.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PositionMyBatis {
    List<Position> getAllPos();
    Optional<Position> getOnePos(@Param("positionId")Long positionId);
    void savePos(Position position);
    void editPos(Position position);
    void deletePos(@Param("positionId")Long positionId);
}
