package com.meli.DiplomasAPISpring.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DiplomaDTO {
   private String nameStudent, message;
   private double averageSubject;
}
