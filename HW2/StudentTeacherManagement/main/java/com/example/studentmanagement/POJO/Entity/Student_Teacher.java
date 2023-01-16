package com.example.studentmanagement.POJO.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "teacher_student")
@NoArgsConstructor
@AllArgsConstructor
public class Student_Teacher {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "s_id")
   private Student stu;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "t_id")
   private Teacher tea;
}
