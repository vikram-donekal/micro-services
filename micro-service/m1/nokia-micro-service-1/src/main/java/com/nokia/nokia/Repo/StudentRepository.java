package com.nokia.nokia.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokia.nokia.DTO.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
