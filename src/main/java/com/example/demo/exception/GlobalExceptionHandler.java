package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demo.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(StudentExistException.class)
  public ResponseEntity<ErrorResponse> handleUsernameException(StudentExistException ex) {
    
    ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

}
