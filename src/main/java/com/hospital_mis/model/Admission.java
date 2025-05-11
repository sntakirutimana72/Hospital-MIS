package com.hospital_mis.model;

import lombok.Getter;

public final class Admission extends IdentifiableEntity {
  @Getter private final int patientId, admittedById;

  public Admission(int id, int patientId, int admittedById) {
    super(id);
    this.patientId = patientId;
    this.admittedById = admittedById;
  }
}
