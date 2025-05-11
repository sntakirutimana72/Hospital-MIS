package com.hospital_mis.util;

import com.hospital_mis.exception.AbortException;
import com.hospital_mis.exception.ValidationException;
import com.hospital_mis.model.Patient;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public final class UserPrompt {
  private UserPrompt() {}

  public static String getText(Scanner scanner, String tag, Consumer<String> validator) throws AbortException {
    while (true) {
      try {
        System.out.print(tag);
        String value = scanner.nextLine();

        Policies.exist(value);
        Policies.abort(value);
        validator.accept(value);

        return value;
      } catch (ValidationException e) {
        Printer.alert(e.getMessage());
      }
    }
  }

  public static int getInt(Scanner scanner, String tag) throws AbortException {
    while (true) {
      try {
        return Integer.parseInt(getText(scanner, tag, (s) -> {}));
      } catch (NumberFormatException ignored) {
        Printer.alert("Invalid number");
      }
    }
  }

  public static int getPositiveInt(Scanner scanner, String tag, int min) throws AbortException {
    int value = getInt(scanner, tag);
    while (true) {
      if (value < Math.max(0, min)) {
        Printer.alert("Value must be a positive value >= " + Math.max(0, min));
        continue;
      }
      return value;
    }
  }

  public static int select(String tag, Scanner scanner, List<String> items) throws AbortException {
    while (true) {
      try {
        // Display available options
        Printer.list(tag, items);
        // Now, get user choice
        int selection = getInt(scanner, "> ");
        // Check if given choice is acceptable
        if (selection < 1 || selection > items.size())
          throw new IllegalArgumentException("Invalid choice");
        return selection - 1;
      } catch (IllegalArgumentException e) {
        Printer.alert(e.getMessage());
      }
    }
  }

  public static Patient selectPatient(String tag, Scanner scanner, List<Patient> items) throws AbortException {
    if (items.isEmpty())
      throw new IllegalArgumentException("No patient records found");

    int index = select(
      String.format("Select %s", tag),
      scanner,
      items.stream().map(Patient::getName).toList()
    );
    return items.get(index);
  }
}
