package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;
import com.example.Academy_employee_managment.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDeps(){
        List<DepartmentResponse>deps= departmentService.depGetAll();
        return ResponseEntity.ok(deps);
    }
    @GetMapping("/id/{departmentId}")
    public ResponseEntity <DepartmentResponse> getDepartmenById(@PathVariable("departmentId")Long departmentId){
        DepartmentResponse dep= departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(dep);
    }
    @PostMapping
    public ResponseEntity <Void> saveDeps(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.saveDep(departmentRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("id/{departmentId}")
    public ResponseEntity <Void> editDeps(@PathVariable("departmentId")Long departmentId,
                                               @RequestBody DepartmentRequest departmentRequest){
        departmentService.editDep(departmentId,departmentRequest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("id/{departmentId}")
    public ResponseEntity <Void> deleteDeps(@PathVariable("departmentId")Long departmentId){
        departmentService.deleteDep(departmentId);
        return ResponseEntity.ok().build();
    }
}
