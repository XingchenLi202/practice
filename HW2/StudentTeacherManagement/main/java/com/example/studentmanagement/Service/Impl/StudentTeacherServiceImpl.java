package com.example.studentmanagement.Service.Impl;

import com.example.studentmanagement.Exception.ResourceNotFoundException;
import com.example.studentmanagement.POJO.Entity.Student;
import com.example.studentmanagement.POJO.Entity.Student_Teacher;
import com.example.studentmanagement.POJO.Entity.Teacher;
import com.example.studentmanagement.Repository.StudentTeacherRepository;
import com.example.studentmanagement.Service.StudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentTeacherServiceImpl implements StudentTeacherService {

   private final StudentTeacherRepository studentTeacherRepository;

   @Autowired
   public StudentTeacherServiceImpl(StudentTeacherRepository studentTeacherRepository){
      this.studentTeacherRepository = studentTeacherRepository;
   }

   //get
   @Override
   @Transactional(rollbackFor = Exception.class)
   public List<Student> getStudentsByTeacherId(int teacherId) {
      return null;
   }

   @Override
   @Transactional(rollbackFor = Exception.class)
   public List<Teacher> getTeachersByStudentId(int studentId) {
      return null;
   }

   @Override
   public Student_Teacher saveStudentTeacher(Student_Teacher st) {
      return studentTeacherRepository.save(st);
   }

   @Override
   @Transactional(rollbackFor = Exception.class)
   public Student_Teacher updateStudentTeacher(Student_Teacher st, int id) {
      return null;
   }

   @Override
   @Transactional(rollbackFor = Exception.class)
   public void deleteStudentTeacher(int id) {
      studentTeacherRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Student_Teacher not found."));
      studentTeacherRepository.deleteById(id);
   }
}
