package com.hospital_mis.model;

import lombok.Getter;

public final class Ward extends IdentifiableEntity {
  @Getter private final int wardNumber, departmentId, supervisorId, numOfBeds;
  @Getter private final WardStatus status;

  public Ward(int id, int wardNumber, int departmentId, int supervisorId, int numOfBeds, WardStatus status) {
    super(id);
    this.wardNumber = wardNumber;
    this.departmentId = departmentId;
    this.supervisorId = supervisorId;
    this.numOfBeds = numOfBeds;
    this.status = status;
  }
}
