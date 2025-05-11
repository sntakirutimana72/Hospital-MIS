package com.hospital_mis.util;

import com.hospital_mis.exception.AbortException;

public final class Policies {
  private Policies() {}

  public static void exist(String userInput) {
    if (userInput.equals("exit")) {
      Printer.alert("Application existing...");
      System.exit(0);
    }
  }

  public static void abort(String userInput) throws AbortException {
    if (userInput.equals("..."))
      throw new AbortException(null);
  }
}
