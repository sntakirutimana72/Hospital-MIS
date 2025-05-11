package com.hospital_mis.model;

import lombok.Getter;

public final class Department extends IdentifiableEntity {
  @Getter private final String name;
  @Getter private final int directorId, buildingId;

  public Department(int id, String name, int directorId, int buildingId) {
    super(id);
    this.name = name;
    this.directorId = directorId;
    this.buildingId = buildingId;
  }
}
