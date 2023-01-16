package com.example.studentmanagement.Service;

import com.example.studentmanagement.POJO.Entity.Student;
import com.example.studentmanagement.POJO.dto.StudentResponseDTO;
import org.springframework.stereotype.Service;
import static com.example.studentmanagement.POJO.dto.StudentResponseDTO.*;

@Service
public interface StudentService {
   //Get API
   StudentResponseDTO getAllStudent();
   StudentDTO getStudentById(int id);

   //Post API
   Student saveStudent(Student student);

   //Put API
   Student updateStudent(Student student, int id);

   //Delete API
   void deleteStudent(int id);
}
