package com.example.studentmanagement.Service.Impl;

import com.example.studentmanagement.Exception.ResourceNotFoundException;
import com.example.studentmanagement.POJO.Entity.Teacher;
import com.example.studentmanagement.POJO.dto.TeacherResponseDTO;
import com.example.studentmanagement.Repository.TeacherRepository;
import com.example.studentmanagement.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.studentmanagement.POJO.dto.TeacherResponseDTO.*;

@Service
public class TeacherServiceImpl implements TeacherService {

   private final TeacherRepository teacherRepository;

   @Autowired
   public TeacherServiceImpl(TeacherRepository teacherRepository){
      this.teacherRepository = teacherRepository;
   }

   //Get: all teachers
   @Transactional(rollbackFor = Exception.class)
   @Override
   public TeacherResponseDTO getAllTeacher() {
      Collection<Teacher> teacherCollection = teacherRepository.findAll();
      List<TeacherDTO> teacherDTOS = teacherCollection
            .stream()
            .map(t -> new TeacherDTO(t))
            .collect(Collectors.toList());
      return new TeacherResponseDTO(teacherDTOS);
   }

   //Get: by id
   @Override
   @Transactional(rollbackFor = Exception.class)
   public TeacherDTO getTeacherById(int id) {
      Optional<Teacher> teacherOptional = teacherRepository.findById(id);
      if(!teacherOptional.isPresent()) {
         throw new ResourceNotFoundException("Teacher not found.");
      } else {
         return new TeacherDTO(teacherOptional.get());
      }
   }

   //Post
   @Override
   public Teacher saveTeacher(Teacher teacher) {
      return teacherRepository.save(teacher);
   }

   //Put
   @Override
   @Transactional(rollbackFor = Exception.class)
   public Teacher updateTeacher(Teacher newTeacher, int id) {
      Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Teacher not found."));
      existingTeacher.setId(newTeacher.getId());
      existingTeacher.setName(newTeacher.getName());

      teacherRepository.save(existingTeacher);
      return existingTeacher;
   }

   @Override
   @Transactional(rollbackFor = Exception.class)
   public void deleteTeacher(int id) {
      Teacher teacher = teacherRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Teacher not found."));
      teacherRepository.deleteById(id);
   }
}
