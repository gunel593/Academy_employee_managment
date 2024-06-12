//package com.example.Academy_employee_managment.mapper;
//
//import com.example.Academy_employee_managment.model.dto.request.DepartmentRequest;
//import com.example.Academy_employee_managment.model.dto.responce.DepartmentResponse;
//import com.example.Academy_employee_managment.model.dto.responce.EmployeeResponse;
//import com.example.Academy_employee_managment.model.dto.wrapper.EmpWrapper;
//import com.example.Academy_employee_managment.model.entity.Department;
//import com.example.Academy_employee_managment.model.entity.Employee;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@SpringBootTest
//public class EmployeeMapperTest {
//    @Autowired
//    private EmployeeMapper employeeMapper;
//
//    @Test
//    public void testEmployeeMapper() {
//        EmpWrapper empWrapper = EmpWrapper.builder().employeeId(2L).empName("Gunel")
//                .empSurname("Quluyeva").empEmail("fdjbfs@gmail.com")
//                .status(1).build();
//        EmployeeResponse expected = EmployeeResponse.builder().employeeId(2L).empName("Gunel")
//                .empSurname("Quluyeva").empEmail("fdjbfs@gmail.com")
//                .status(1).build();
//        EmployeeResponse actual = employeeMapper.toempResponce(empWrapper);
//        assertEquals(expected, actual);
//    }
//}

