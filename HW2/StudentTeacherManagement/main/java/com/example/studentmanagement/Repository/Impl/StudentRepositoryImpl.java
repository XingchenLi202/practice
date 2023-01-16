package com.example.studentmanagement.Repository.Impl;

import com.example.studentmanagement.POJO.Entity.Student;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Hard code test
//@Repository
//public class StudentRepositoryImpl implements StudentRepository {
//   private final Map<Integer, Student> map = new ConcurrentHashMap<>();
//   @PostConstruct
//   public void init(){
//      map.put(1, new Student(1, "Tom", "A"));
//      map.put(2, new Student(2, "Jerry", "B"));
//      map.put(3, new Student(3, "Mark", "C"));
//   }
//
//   @Override
//   public Student findById(int id) {
//      return map.get(id);
//   }
//
//   @Override
//   public Collection<Student> findAll() {
//      return map.values();
//   }
//}
