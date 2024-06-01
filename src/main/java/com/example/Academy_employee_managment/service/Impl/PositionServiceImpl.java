package com.example.Academy_employee_managment.service.Impl;

import com.example.Academy_employee_managment.mapper.PositionMapper;
import com.example.Academy_employee_managment.model.dto.request.PositionResquest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponce;
import com.example.Academy_employee_managment.model.dto.wrapper.Wrapper;
import com.example.Academy_employee_managment.model.entity.Position;
import com.example.Academy_employee_managment.mybatis.PositionMyBatis;
import com.example.Academy_employee_managment.service.PositionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionMapper positionMapper;
    private final PositionMyBatis positionMyBatis;
    @Override
    public List<PositionResponce> posGetAll() {
        List<Wrapper> wrapperList =positionMyBatis.getAllPos();
        List<PositionResponce>positionList= positionMapper.topositionList(wrapperList);
        return positionList;
    }



    @Override
    public PositionResponce getPositionById(Long positionId) {
        Wrapper wrapper=positionMyBatis.getPositionById(positionId);//.orElse(null);
        return  positionMapper.toposResponce(wrapper);
       // return wrapperOptional.map(positionMapper::toposResponce).orElse(null);
    }

    @Override
    public void savePos(PositionResquest positionResquest) {
        log.info("Insert received.PositionRequest:{}",positionResquest);
        Position positions=positionMapper.toPosition(positionResquest);
        log.info("positionMapper mapped to to Position.position:{}",positions);
         positionMyBatis.savePos(positions);
        log.info("Add process was succesfull.");
        log.warn("Just warning{}",positionResquest);
        log.error("Just error.{}",positionResquest);
    }

    @Override
    public void editPos(Long positionId, PositionResquest positionResquest) {
        Position positions=positionMapper.toPositionByID(positionId,positionResquest);
        positionMyBatis.editPos(positions);
    }

    @Override
    public void deletePos(Long positionId) {
      positionMyBatis.deletePos(positionId);
    }
}
