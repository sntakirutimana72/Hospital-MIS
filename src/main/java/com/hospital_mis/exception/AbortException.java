package com.hospital_mis.exception;

import java.util.Objects;

public final class AbortException extends Exception {
  public AbortException(String message) {
    super(Objects.isNull(message) ? "Going back" : message);
  }
}