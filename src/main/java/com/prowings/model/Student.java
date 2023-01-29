package com.prowings.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Student
 */
@Data
public class Student   {
  private String address;

  private String name;

  private Integer roll;

  public Student address(String address) {
    this.address = address;
    return this;
  }

}

