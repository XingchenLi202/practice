package com.example.studentmanagement.Service.Impl;

import com.example.studentmanagement.Exception.ResourceNotFoundException;
import com.example.studentmanagement.POJO.Entity.Student;
import com.example.studentmanagement.POJO.dto.StudentResponseDTO;
import static com.example.studentmanagement.POJO.dto.StudentResponseDTO.*;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

   private final StudentRepository studentRepository;

   @Autowired
   public StudentServiceImpl(StudentRepository studentRepository){
      this.studentRepository = studentRepository;
   }

   //Get: all students
   @Override
   @Transactional(rollbackFor = Exception.class)
   public StudentResponseDTO getAllStudent() {
      Collection<Student> studentCollection = studentRepository.findAll();
      List<StudentDTO> studentDTOS = studentCollection
            .stream()
            .map(s -> new StudentDTO(s))
            .collect(Collectors.toList());

      return new StudentResponseDTO(studentDTOS);
   }

   //Get: by id
   @Transactional(rollbackFor = Exception.class)
   @Override
   public StudentDTO getStudentById(int id) {
      //log id
      Optional<Student> student = studentRepository.findById(id);
      //log employee info
      if(!student.isPresent()) {
         //log exception
         throw new ResourceNotFoundException("Student not found.");
      } else {
         return new StudentDTO(student.get());
      }
      //return new StudentDTO(student);
//            StudentDTO.builder()
//            .id(id)
//            .name("Sam")
//            .build();
   }

   //Post
   @Override
   public Student saveStudent(Student student) {
      return studentRepository.save(student);
   }

   //Put
   @Override
   @Transactional(rollbackFor = Exception.class)
   public Student updateStudent(Student newStudent, int id) {
      Optional<Student> optional = studentRepository.findById(id);
      if(!optional.isPresent()){
         throw new ResourceNotFoundException("Student not found.");
      } else {
         Student existingStudent = optional.get();

         existingStudent.setId(newStudent.getId());
         existingStudent.setName(newStudent.getName());

         studentRepository.save(existingStudent);
         return existingStudent;
      }
   }

   //Delete
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void deleteStudent(int id) {
      studentRepository.findById(id).orElseThrow(() ->
               new ResourceNotFoundException("Student not found."));
      studentRepository.deleteById(id);
   }
}
