package com.hospital_mis.model;

import lombok.Getter;

public abstract class IdentifiableUser extends IdentifiableEntity {
  @Getter private final String surname, address, phone;

  public IdentifiableUser(int id, String surname, String address, String phone) {
    super(id);
    this.surname = surname;
    this.address = address;
    this.phone = phone;
  }
}
