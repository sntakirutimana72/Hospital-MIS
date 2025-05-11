package com.hospital_mis.model;

import lombok.Getter;

public abstract class Employee extends IdentifiableUser {
  @Getter private final String firstname;

  public Employee(int id, String firstname, String surname, String address, String phone) {
    super(id, surname, address, phone);
    this.firstname = firstname;
  }
}
