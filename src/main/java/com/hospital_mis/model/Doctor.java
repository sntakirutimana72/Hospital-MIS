package com.hospital_mis.model;

import lombok.Getter;

public final class Doctor extends Employee {
  @Getter private final int employeeId, specialtyId;

  public Doctor(int id, String firstname, String surname, String address, String phone, int employeeId, int specialtyId) {
    super(id, firstname, surname, address, phone);
    this.employeeId = employeeId;
    this.specialtyId = specialtyId;
  }
}
