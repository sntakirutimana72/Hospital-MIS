package com.hospital_mis.util;

import java.util.ArrayList;
import java.util.List;

public final class Printer {
  private Printer() {}

  public static void list(String label, List<String> items) {
    // Show guiding message before printing options
    System.out.println("*** " + label + " ***");
    for (int i = 0; i < items.size(); i++)
      System.out.printf(" %d. %s%n", i + 1, items.get(i));
  }

  public static void tabular(String title, List<String> columns, List<List<String>> rows) {
    // Calculate max width for each column
    List<Integer> colWidths = new ArrayList<>();
    for (int i = 0; i < columns.size(); i++) {
      int max = columns.get(i).length();
      for (List<String> row : rows) {
        max = Math.max(max, row.get(i).length());
      }
      colWidths.add(max);
    }

    // Print header
    int padding = colWidths.stream().mapToInt(Integer::intValue).sum() + columns.size() * 3 - 1;
    String bar = "+" + "-".repeat(padding) + "+";
    System.out.println(bar);
    System.out.printf(
      "|%s%s%s|%n", " ".repeat((padding - title.length()) / 2), title,
      " ".repeat(Double.valueOf(Math.ceil((padding - title.length()) / 2.0)).intValue()));
    System.out.println(bar);

    // Print column names
    for (int i = 0; i < columns.size(); i++) {
      System.out.printf("| %-" + colWidths.get(i) + "s ", columns.get(i));
    }
    System.out.println("|");

    // Print separator
    for (int width : colWidths) {
      System.out.print("+");
      System.out.print("-".repeat(width + 2));
    }
    System.out.println("+");

    // Print rows
    for (List<String> row : rows) {
      for (int i = 0; i < columns.size(); i++) {
        String cell = i < row.size() ? row.get(i) : "";
        System.out.printf("| %-" + colWidths.get(i) + "s ", cell);
      }
      System.out.println("|");
    }

    // Print bottom bar
    System.out.println(bar);
  }

  public static void alert(String message) {
    int dashing = Math.max(message.length() + 4, 50);
    int padding = dashing - message.length();
    String x = "+" + "-".repeat(dashing) + "+";
    System.out.println(x);
    System.out.printf(
      "|%s%s%s|%n",
      " ".repeat(padding / 2), message,
      " ".repeat(Double.valueOf(Math.ceil(padding / 2.0)).intValue()));
    System.out.println(x);
  }
}
