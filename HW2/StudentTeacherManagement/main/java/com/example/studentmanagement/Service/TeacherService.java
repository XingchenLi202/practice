package com.example.studentmanagement.Service;

import com.example.studentmanagement.POJO.Entity.Teacher;
import com.example.studentmanagement.POJO.dto.TeacherResponseDTO;
import org.springframework.stereotype.Service;

import static com.example.studentmanagement.POJO.dto.TeacherResponseDTO.*;

@Service
public interface TeacherService {
   //Get API
   TeacherResponseDTO getAllTeacher();
   TeacherDTO getTeacherById(int id);

   //Post API
   Teacher saveTeacher(Teacher teacher);

   //Put API
   Teacher updateTeacher(Teacher teacher, int id);

   //Delete API
   void deleteTeacher(int id);
}
