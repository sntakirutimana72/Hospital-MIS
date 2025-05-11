package com.hospital_mis.model;

import lombok.Getter;

import java.time.LocalTime;

public final class Rotation extends IdentifiableEntity {
  @Getter private final LocalTime startTime, endTime;

  public Rotation(int id, LocalTime startTime, LocalTime endTime) {
    super(id);
    this.startTime = startTime;
    this.endTime = endTime;
  }
}
