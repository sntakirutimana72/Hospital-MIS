package com.hospital_mis.util.validator;

import com.hospital_mis.exception.ValidationException;

public class PatientValidator {
  private PatientValidator() {}

  public static void validateNameOrSurname(String name) {
    if (name.isBlank() || !name.matches("^(?i)[a-z]{2,}(\\s[a-z]{2,})*$"))
      throw new ValidationException("Invalid patient name/surname");
  }

  public static void validateAddress(String address) {
    if (address.isBlank() || !address.matches("^(?i)[a-z-0-9]+(\\s[a-z0-9_\\-.]+)*$"))
      throw new ValidationException("Invalid patient address");
  }

  public static void validatePhone(String phone) {
    if (phone.isBlank() || !phone.matches("^(?:\\+2507|07)\\d{8}$"))
      throw new ValidationException("Invalid patient phone number");
  }
}
