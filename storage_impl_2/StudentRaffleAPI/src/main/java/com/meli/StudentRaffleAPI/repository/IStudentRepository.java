package com.meli.StudentRaffleAPI.repository;

import com.meli.StudentRaffleAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
