package com.meli.StudentRaffleAPI.service;

import com.meli.StudentRaffleAPI.model.Student;

import java.util.List;

public interface IStudentService {
   List<Student> getStudentsRandom();
}
