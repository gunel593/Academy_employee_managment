package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.PositionResquest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponce;
import com.example.Academy_employee_managment.model.dto.wrapper.ConnectRapper;
import com.example.Academy_employee_managment.model.entity.Position;
import com.example.Academy_employee_managment.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;
    @GetMapping
    public ResponseEntity<List<ConnectRapper>> getAllPos(){
        List<ConnectRapper> poss= positionService.posGetAll();
        return ResponseEntity.ok(poss);
    }
    @GetMapping("positionId/{positionId}")
    public ResponseEntity <PositionResponce> getPositionById(@PathVariable("positionId")Long positionId){
        PositionResponce pos= positionService.getPositionById(positionId);
        return ResponseEntity.ok(pos);
    }
    @PostMapping
    public ResponseEntity <Void> savePos(@RequestBody PositionResquest positionResquest) {
        positionService.savePos(positionResquest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("positionId/{positionId}")
    public ResponseEntity <Void> editPos(@PathVariable("positionId")Long positionId,
                                          @RequestBody PositionResquest positionResquest){
        positionService.editPos(positionId,positionResquest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("positionId/{positionId}")
    public ResponseEntity <Void> deletePos(@PathVariable("positionId")Long positionId){
        positionService.deletePos(positionId);
        return ResponseEntity.ok().build();
    }
}
