package com.example.studentmanagement.POJO.dto;

import com.example.studentmanagement.POJO.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentResponseDTO {
   public List<StudentDTO> studentDTOList;

   @Data
   @AllArgsConstructor
   @Builder
   public static class StudentDTO {
      public int id;
      public String name;

      public StudentDTO(Student s) {
         this.id = s.getId();
         this.name = s.getName();
      }
   }
}
