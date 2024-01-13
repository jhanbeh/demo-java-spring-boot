package com.example.demo.dto;

public class StudentRegisterRes {

  private String name;

  private boolean registerSuccess;

  private String reason;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isRegisterSuccess() {
    return registerSuccess;
  }

  public void setRegisterSuccess(boolean registerSuccess) {
    this.registerSuccess = registerSuccess;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public String toString() {
    return "StudentRegisterRes [name=" + name + ", registerSuccess=" + registerSuccess + ", reason="
        + reason + "]";
  }

}
