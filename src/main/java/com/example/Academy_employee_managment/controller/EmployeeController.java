package com.example.Academy_employee_managment.controller;

import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
import com.example.Academy_employee_managment.model.dto.request.EmployeeResquest;
import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponce;
import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponce;
import com.example.Academy_employee_managment.service.DepartmentService;
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
    public ResponseEntity<List<EmployeeResponce>> getAllEmps(){
        List<EmployeeResponce> emps= employeeService.empGetAll();
        return ResponseEntity.ok(emps);
    }
    @GetMapping("employeeId/{employeeId}")
    public ResponseEntity <EmployeeResponce> getEmployeeById(@PathVariable("employeeId")Long employeeId){
        EmployeeResponce emp= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(emp);
    }
    @PostMapping
    public ResponseEntity <Void> saveEmps(@RequestBody EmployeeResquest employeeResquest) {
        employeeService.saveEmp(employeeResquest);
        return ResponseEntity.ok().build();
    }
    @PutMapping("employeeId/{employeeId}")
    public ResponseEntity <Void> editEmps(@PathVariable("employeeId")Long employeeId,
                                          @RequestBody EmployeeResquest employeeResquest){
        employeeService.editEmp(employeeId,employeeResquest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("employeeId/{employeeId}")
    public ResponseEntity <Void> deleteEmps(@PathVariable("employeeId")Long employeeId){
        employeeService.deleteEmp(employeeId);
        return ResponseEntity.ok().build();
    }
}
