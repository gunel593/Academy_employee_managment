 package com.example.Academy_employee_managment.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorDetails> handleUserNotExistsException(CommonException exception) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getCode(), exception.getDescription());
        return ResponseEntity.status(exception.getHttpStatusCode()).body(errorDetails);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>handleInternalServerError(Exception exception){
        exception.printStackTrace();
        ErrorDetails errorDetails= new ErrorDetails("5500", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDetails);
    }
}
