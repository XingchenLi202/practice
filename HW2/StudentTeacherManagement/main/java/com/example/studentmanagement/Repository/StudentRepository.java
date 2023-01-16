package com.example.studentmanagement.Repository;

import com.example.studentmanagement.POJO.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

   //Hard Code test
//   Student findById(int id);
//   Collection<Student> findAll();
}
