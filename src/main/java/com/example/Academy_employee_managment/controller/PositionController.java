package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.PositionRequest;
import com.example.Academy_employee_managment.model.dto.responce.PositionResponse;
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
    public ResponseEntity<List<PositionResponse>> getAllPos(){
        List<PositionResponse> poss= positionService.posGetAll();
        return ResponseEntity.ok(poss);
    }
    @GetMapping("id/{positionId}")
    public ResponseEntity <PositionResponse> getPositionById(@PathVariable("positionId")Long positionId,
                                                             @PathVariable("departmentId")Long departmentId
                                                             ){
        PositionResponse pos= positionService.getPositionById(positionId);
        return ResponseEntity.ok(pos);
    }
    @PostMapping
    public ResponseEntity <Void> savePos(@RequestBody PositionRequest positionRequest) {
        positionService.savePos(positionRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("id/{positionId}")
    public ResponseEntity <Void> editPos(@PathVariable("positionId")Long positionId,
                                          @RequestBody PositionRequest positionRequest){
        positionService.editPos(positionId, positionRequest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("id/{positionId}")
    public ResponseEntity <Void> deletePos(@PathVariable("positionId")Long positionId){
        positionService.deletePos(positionId);
        return ResponseEntity.ok().build();
    }
}
