package com.example.studentmanagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException e) {
      return new ResponseEntity<>(e.getMessage() + " Handle Resource Not Found Exception!", HttpStatus.NOT_FOUND);
   }

}
