package com.hospital_mis.model;

import lombok.Getter;

public final class Building extends IdentifiableEntity {
  @Getter private final String name;

  public Building(int id, String name) {
    super(id);
    this.name = name;
  }
}
