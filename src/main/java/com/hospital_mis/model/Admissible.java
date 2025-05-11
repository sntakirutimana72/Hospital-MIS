package com.hospital_mis.model;

import lombok.Getter;

public abstract class Admissible extends IdentifiableEntity {
  @Getter private final int admissionId;

  public Admissible(int id, int admissionId) {
    super(id);
    this.admissionId = admissionId;
  }
}
