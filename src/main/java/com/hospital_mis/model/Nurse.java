package com.hospital_mis.model;

import lombok.Getter;

public final class Nurse extends Employee {
  @Getter private final double salary;
  @Getter private final int employeeId, rotationId, departmentId;

  public Nurse(int id, String firstname, String surname, String address, String phone,
               int employeeId, int rotationId, int departmentId, double salary) {
    super(id, firstname, surname, address, phone);
    this.employeeId = employeeId;
    this.rotationId = rotationId;
    this.departmentId = departmentId;
    this.salary = salary;
  }
}
