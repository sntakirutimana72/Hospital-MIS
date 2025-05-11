package com.hospital_mis.model;

import lombok.Getter;

public final class Diagnosis extends Admissible {
  @Getter private final int doneById;
  @Getter private final String description, results;

  public Diagnosis(int id, int doneById, int admissionId, String description, String results) {
    super(id, admissionId);
    this.doneById = doneById;
    this.description = description;
    this.results = results;
  }
}
