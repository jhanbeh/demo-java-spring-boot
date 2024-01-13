package com.example.demo.exception;

public class StudentExistException extends RuntimeException {

  public StudentExistException(String username) {
    super("USERNAME has been registered: " + username);
  }

}


