package com.hospital_mis.model;

import lombok.Getter;

public final class Patient extends IdentifiableUser {
  @Getter private final String name;

  public Patient(int id, String name, String surname, String address, String phone) {
    super(id, surname, address, phone);
    this.name = name;
  }
}
