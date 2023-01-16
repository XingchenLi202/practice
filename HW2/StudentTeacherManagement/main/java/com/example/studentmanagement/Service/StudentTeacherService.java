package com.example.studentmanagement.Service;

import com.example.studentmanagement.POJO.Entity.Student;
import com.example.studentmanagement.POJO.Entity.Student_Teacher;
import com.example.studentmanagement.POJO.Entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentTeacherService {
   //get
   List<Student> getStudentsByTeacherId(int teacherId);
   List<Teacher> getTeachersByStudentId(int studentId);

   //post
   Student_Teacher saveStudentTeacher(Student_Teacher st);

   //put
   Student_Teacher updateStudentTeacher(Student_Teacher st, int id);

   //delete
   void deleteStudentTeacher(int id);
}
