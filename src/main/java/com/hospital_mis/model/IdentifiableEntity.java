package com.hospital_mis.model;

import lombok.Getter;

public abstract class IdentifiableEntity {
  @Getter private final int id;

  public IdentifiableEntity(int id) {
    this.id = id;
  }
}
