package com.example.demo.dto;

import java.math.BigDecimal;

public class StudentUpdateRes {

  private String username;

  private String name;

  private BigDecimal age;

  private String gender;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getAge() {
    return age;
  }

  public void setAge(BigDecimal age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "StudentUpdateRes [username=" + username + ", name=" + name + ", age=" + age
        + ", gender=" + gender + "]";
  }

}
