package com.example.studentmanagement.POJO.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor

public class Teacher {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   @Column
   private String name;
   @Column
   private int age;

   @OneToMany(mappedBy = "tea", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
   private List<Student_Teacher> student_teachers;

   public List<Student_Teacher> getAllStudent_Teachers() {
      return student_teachers;
   }

   public void setAllStudent_Teachers(List<Student_Teacher> sts){
      this.student_teachers = sts;
   }

   public void addStudent_Teacher(Student_Teacher st){
      this.student_teachers.add(st);
   }
}
