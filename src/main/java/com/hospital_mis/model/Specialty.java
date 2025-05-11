package com.hospital_mis.model;

import lombok.Getter;

public final class Specialty extends IdentifiableEntity {
  @Getter
  private final String name;

  public Specialty(int id, String name) {
    super(id);
    this.name = name;
  }
}
