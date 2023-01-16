package com.example.studentmanagement.Repository;

import com.example.studentmanagement.POJO.Entity.Student_Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentTeacherRepository extends JpaRepository<Student_Teacher, Integer> {
}
