package com.meli.DiplomasAPISpring.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Student {
   private String name;
   private List<Subject> listSubject;

}
