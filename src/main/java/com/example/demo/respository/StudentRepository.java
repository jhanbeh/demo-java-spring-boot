package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.enity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

  Student findByUsername(String username);

}
