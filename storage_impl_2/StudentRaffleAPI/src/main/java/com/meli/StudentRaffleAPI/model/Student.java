package com.meli.StudentRaffleAPI.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "STUDENT")
public class Student {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer ID;

   @Column(name = "FIRST_NAME")
   private String firstName;

   @Column(name = "LAST_NAME")
   private String lastName;
}
