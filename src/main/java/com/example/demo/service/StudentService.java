package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.dto.StudentRegisterReq;
import com.example.demo.dto.StudentRegisterRes;
import com.example.demo.dto.StudentUpdateRes;
import com.example.demo.enity.Student;
import com.example.demo.exception.StudentExistException;
import com.example.demo.respository.StudentRepository;
import jakarta.transaction.Transactional;

@Service
public class StudentService {

  private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<StudentRegisterRes> executeMockData(List<StudentRegisterReq> req) {

    LOG.info("Mock Req to register students : {}", req);

    List<StudentRegisterRes> res = new ArrayList<>();
    for (StudentRegisterReq rq : req) {
      StudentRegisterRes rs = new StudentRegisterRes();
      if (validateReq(rq)) {
        rs.setName(rq.getName());
        rs.setRegisterSuccess(true);
        rs.setReason("Needed info provided.");
      } else {
        rs.setRegisterSuccess(false);
        rs.setReason("Missing Mandatory field");
      }
      res.add(rs);
    }

    LOG.info("Mock Res to register students : {}", res);
    return res;
  }

  @Transactional
  public List<StudentRegisterRes> executeRegistration(List<StudentRegisterReq> req)
      throws Exception {

    LOG.info("Req to register students : {}", req);

    List<StudentRegisterRes> res = new ArrayList<>();
    for (StudentRegisterReq rq : req) {
      Student std = new Student();
      if (validateUsernameForInsert(rq.getUsername()).isEmpty()) {
        BeanUtils.copyProperties(rq, std);
        std.setId(UUID.randomUUID().toString());
        StudentRegisterRes rs = new StudentRegisterRes();
        Student etRes = studentRepository.save(std);
        BeanUtils.copyProperties(etRes, rs);
        rs.setRegisterSuccess(etRes != null ? true : false);
        res.add(rs);
      }
    }

    LOG.info("Res to register students : {}", res);
    return res;
  }

  @Transactional
  public StudentUpdateRes executeUpdate(StudentRegisterReq req) throws Exception {

    LOG.info("Req to update students : {}", req);

    Optional<Student> result = validateUsernameForUpdate(req.getUsername());

    BeanUtils.copyProperties(req, result.get());
    Student etRes = studentRepository.save(result.get());

    StudentUpdateRes stdRes = new StudentUpdateRes();
    BeanUtils.copyProperties(etRes, stdRes);

    LOG.info("Res to update students : {}", stdRes);
    return stdRes;
  }

  @Transactional
  public List<StudentUpdateRes> executeAll() {

    List<StudentUpdateRes> rs = new ArrayList<>();
    List<Student> res = studentRepository.findAll();

    for (Student std : res) {
      StudentUpdateRes sur = new StudentUpdateRes();
      BeanUtils.copyProperties(std, sur);
      rs.add(sur);
    }

    LOG.info("Res to get all students: {}", rs);
    return rs;
  }

  @Transactional
  public Page<StudentUpdateRes> executeAllViaPageable(Pageable pg) {

    Page<Student> res = studentRepository.findAll(pg);

    List<StudentUpdateRes> content =
        res.getContent().stream().map(this::mapToStudentUpdateRes).collect(Collectors.toList());

    LOG.info("Res to get all students: {}", res);
    return new PageImpl<>(content, pg, res.getTotalElements());
  }

  private boolean validateReq(StudentRegisterReq rq) {
    return rq.getName() != null && rq.getAge() != null && rq.getGender() != null;
  }

  // validate username from db, throw exception is username exist
  private Optional<Student> validateUsernameForInsert(String username) {
    Optional<Student> et =
        Optional.ofNullable(studentRepository.findByUsername(username));

    if (et.isPresent()) {
      throw new StudentExistException(et.get().getUsername());
    } else {
      return Optional.empty();
    }
  }

  // validate username from db, return entity if exist or else throw exceptions
  private Optional<Student> validateUsernameForUpdate(String username) {
    Optional<Student> et =
        Optional.ofNullable(studentRepository.findByUsername(username));

    if (et.isPresent()) {
      return et;
    } else {
      throw new StudentExistException(et.get().getUsername());
    }
  }

  // map Student to StudentUpdateRes
  private StudentUpdateRes mapToStudentUpdateRes(Student student) {
    StudentUpdateRes sur = new StudentUpdateRes();
    BeanUtils.copyProperties(student, sur);
    return sur;
  }

}
