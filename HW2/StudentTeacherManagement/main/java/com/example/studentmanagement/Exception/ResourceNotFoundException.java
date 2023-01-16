package com.example.studentmanagement.Exception;

public class ResourceNotFoundException extends RuntimeException{

   public ResourceNotFoundException(String message) {
      super(message);
   }
}
