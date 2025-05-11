package com.hospital_mis.model;

import lombok.Getter;

import java.time.LocalDateTime;

public final class WardAssignment extends Admissible {
  @Getter private final int signedById, wardId, bedNumber;
  @Getter private final LocalDateTime assignedAt, vacatedAt;

  public WardAssignment(int id, int signedById, int admissionId, int wardId, int bedNumber,
                        LocalDateTime assignedAt, LocalDateTime vacatedAt) {
    super(id, admissionId);
    this.signedById = signedById;
    this.wardId = wardId;
    this.bedNumber = bedNumber;
    this.assignedAt = assignedAt;
    this.vacatedAt = vacatedAt;
  }
}
