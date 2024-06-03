package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.EmployeeRequest;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
import com.example.Academy_employee_managment.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping()
    public ResponseEntity<List<EmployeeResponse>> getAllEmps(){
        List<EmployeeResponse> emps= employeeService.empGetAll();
        return ResponseEntity.ok(emps);
    }
    @GetMapping("id/{employeeId}")
    public ResponseEntity <EmployeeResponse> getEmployeeById(@PathVariable("employeeId")Long employeeId){
        EmployeeResponse emp= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(emp);
    }
    @PostMapping
    public ResponseEntity <Void> saveEmps(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.saveEmp(employeeRequest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("id/{employeeId}")
    public ResponseEntity <Void> editEmps(@PathVariable("employeeId")Long employeeId,
                                          @RequestBody EmployeeRequest employeeRequest){
        employeeService.editEmp(employeeId, employeeRequest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("id/{employeeId}")
    public ResponseEntity <Void> deleteEmps(@PathVariable("employeeId")Long employeeId){
        employeeService.deleteEmp(employeeId);
        return ResponseEntity.ok().build();
    }
}
