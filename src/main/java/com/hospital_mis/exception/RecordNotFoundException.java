package com.hospital_mis.exception;

public class RecordNotFoundException extends Exception {
  public RecordNotFoundException(String prefix) {
    super(prefix + " not found");
  }
}
