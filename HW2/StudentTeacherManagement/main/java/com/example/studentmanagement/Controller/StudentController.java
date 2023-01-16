package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Exception.ResourceNotFoundException;
import com.example.studentmanagement.POJO.Entity.Student;
import static com.example.studentmanagement.POJO.dto.StudentResponseDTO.*;

import com.example.studentmanagement.POJO.dto.StudentResponseDTO;
import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

   private final StudentService studentService;

   @Autowired
   public StudentController(StudentService studentService) {
      this.studentService = studentService;
   }
   //get All student in StudentResponseDTO
//   @GetMapping
//   public StudentResponseDTO getStuDTO() {
//      return new StudentResponseDTO();
//   }


   //Get all student in ResponseEntity
   @GetMapping
   public ResponseEntity<StudentResponseDTO> getStudent(@RequestParam(required = false) String name) {
      return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
      return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
   }

   //Post
   @PostMapping
   public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
      return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
   }

   //Put
   @PutMapping("/{id}")
   public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
      return new ResponseEntity<>(studentService.updateStudent(student, id), HttpStatus.OK);
   }

   //Delete
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteStudent(@PathVariable int id) {
      studentService.deleteStudent(id);
      return new ResponseEntity<>("Delete student successfully", HttpStatus.OK);
   }

//   @ExceptionHandler(ResourceNotFoundException.class)
//   public ResponseEntity<Object> handleException(ResourceNotFoundException ex) {
//      return new ResponseEntity<>("Resource is not found", HttpStatus.NOT_FOUND);
//   }
}

