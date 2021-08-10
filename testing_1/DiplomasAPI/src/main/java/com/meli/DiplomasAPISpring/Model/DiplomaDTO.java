package com.meli.DiplomasAPISpring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DiplomaDTO {
   private String studentName;
   private String message;
   private double averageScore;
   private List<SubjectDTO> subjects;
}
