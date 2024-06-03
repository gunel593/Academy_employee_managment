package com.example.Academy_employee_managment.service.Impl;

import com.example.Academy_employee_managment.mapper.PositionMapper;
import com.example.Academy_employee_managment.model.dto.request.PositionRequest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponse;
import com.example.Academy_employee_managment.model.dto.wrapper.Wrapper;
import com.example.Academy_employee_managment.model.entity.Position;
import com.example.Academy_employee_managment.mybatis.PositionMyBatis;
import com.example.Academy_employee_managment.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionMapper positionMapper;
    private final PositionMyBatis positionMyBatis;
    @Override
    public List<PositionResponse> posGetAll() {
        List<Wrapper> wrapperList =positionMyBatis.getAllPos();
        List<PositionResponse>positionList= positionMapper.topositionList(wrapperList);
        return positionList;
    }



    @Override
    public PositionResponse getPositionById(Long positionId) {
        Wrapper wrapper=positionMyBatis.getPositionById(positionId);//.orElse(null);
        return  positionMapper.toposResponce(wrapper);
       // return wrapperOptional.map(positionMapper::toposResponce).orElse(null);
    }

    @Override
    public void savePos(PositionRequest positionRequest) {
        log.info("Insert received.PositionRequest:{}", positionRequest);
        Position positions=positionMapper.toPosition(positionRequest);
        log.info("positionMapper mapped to to Position.position:{}",positions);
         positionMyBatis.savePos(positions);
        log.info("Add process was succesfull.");
        log.warn("Just warning{}", positionRequest);
        log.error("Just error.{}", positionRequest);
    }

    @Override
    public void editPos(Long positionId, PositionRequest positionRequest) {
        Position positions=positionMapper.toPositionByID(positionId, positionRequest);
        positionMyBatis.editPos(positions);
    }

    @Override
    public void deletePos(Long positionId) {
      positionMyBatis.deletePos(positionId);
    }
}
