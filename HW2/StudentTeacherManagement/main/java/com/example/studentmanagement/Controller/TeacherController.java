package com.example.studentmanagement.Controller;

import com.example.studentmanagement.POJO.Entity.Teacher;
import com.example.studentmanagement.POJO.dto.TeacherResponseDTO;
import static com.example.studentmanagement.POJO.dto.TeacherResponseDTO.*;

import com.example.studentmanagement.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

   private final TeacherService teacherService;

   @Autowired
   public TeacherController(TeacherService teacherService) {
      this.teacherService = teacherService;
   }

   //Get
   @GetMapping
   public ResponseEntity<TeacherResponseDTO> getAllTeacher(@RequestParam(required = false) String name) {
      return new ResponseEntity<>(teacherService.getAllTeacher(), HttpStatus.OK);
   }

   @GetMapping("/{id}")
   public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable int id) {
      return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
   }

   //Post
   @PostMapping
   public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
      return new ResponseEntity<>(teacherService.saveTeacher(teacher), HttpStatus.CREATED);
   }

   //Put
   @PutMapping("/{id}")
   public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
      return new ResponseEntity<>(teacherService.updateTeacher(teacher, id), HttpStatus.OK);
   }

   //Delete
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
      teacherService.deleteTeacher(id);
      return new ResponseEntity<>("Delete teacher successfully", HttpStatus.OK);
   }
}
