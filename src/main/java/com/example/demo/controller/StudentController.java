package com.example.demo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.MovieDto;
import com.example.demo.dto.StudentRegisterReq;
import com.example.demo.dto.StudentRegisterRes;
import com.example.demo.dto.StudentUpdateRes;
import com.example.demo.service.MovieService;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/public/v1/test")
public class StudentController {

  private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

  private final StudentService studentService;

  private final MovieService movieService;

  public StudentController(StudentService studentService, MovieService movieService) {
    this.studentService = studentService;
    this.movieService = movieService;
  }

  // log REQUEST & RESPONSE info into logs file
  @GetMapping("/student")
  public ResponseEntity<List<StudentRegisterRes>> getMockData(
      @RequestBody List<StudentRegisterReq> req) {
    return ResponseEntity.ok(studentService.executeMockData(req));
  }

  // Try insert list of data into db
  @PostMapping("/student-registration")
  public ResponseEntity<List<StudentRegisterRes>> performStudentRegistration(
      @RequestBody List<StudentRegisterReq> req) throws Exception {
    return ResponseEntity.ok(studentService.executeRegistration(req));
  }

  // Try update data into db
  @PostMapping("/student-update")
  public ResponseEntity<StudentUpdateRes> performStudentUpdate(@RequestBody StudentRegisterReq req)
      throws Exception {
    return ResponseEntity.ok(studentService.executeUpdate(req));
  }

  // Try get list of data from db
  @GetMapping("/student-all")
  public ResponseEntity<List<StudentUpdateRes>> getAllStudents() {
    return ResponseEntity.ok(studentService.executeAll());
  }

  // Try get list of data from db via pagination
  @GetMapping("/student-page")
  public ResponseEntity<Page<StudentUpdateRes>> getAllStudentsByPagination(Pageable pageable) {
    return ResponseEntity.ok(studentService.executeAllViaPageable(pageable));
  }

  // Try get list of data from external 3rd party + store into db
  @GetMapping("/external-api")
  public ResponseEntity<List<MovieDto>> getAllMovie() {
    return ResponseEntity.ok(movieService.execute());
  }

}
