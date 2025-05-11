package com.hospital_mis;

import com.hospital_mis.repository.PatientRepository;
import com.hospital_mis.service.PatientService;
import com.hospital_mis.util.Logger.SystemLogger;
import com.hospital_mis.util.Policies;
import com.hospital_mis.util.Printer;
import com.hospital_mis.util.UserPrompt;
import com.hospital_mis.util.db.Migration;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HospitalInformationSystemCLI {
  private final PatientService patientService;

  public HospitalInformationSystemCLI() {
    patientService = new PatientService(new PatientRepository());
  }

  private void configureStartup() {
    SystemLogger.getLogger().info("Configuring application..");
    SystemLogger.getLogger().info("Attempting to run migrations...");
    try {
      Migration.migrate();
      SystemLogger.getLogger().info("Migration completed successfully.");
    } catch (Exception e) {
      SystemLogger.getLogger().error("Migration Failure - {}", e.getMessage());
      Policies.exist("exit");
    }
    SystemLogger.getLogger().info("Configuration successfully complete.");
    SystemLogger.getLogger().info("Application is starting...");
  }

  private void displayStartupMessage() {
    System.out.println();
    Printer.alert("Welcome To Hospital Information Management System");
    System.out.println();
  }

  private void start() {
    configureStartup();
    displayStartupMessage();

    Scanner sc = new Scanner(System.in);
    //noinspection InfiniteLoopStatement
    while (true) {
      try {
        int choice = UserPrompt.select("Select option", sc, List.of(
          "Create Patient",
          "Update Patient",
          "Delete Patient",
          "Find Patient (By ID)",
          "List All Patients",
          "List Patients (By Page)",
          "Total Patients",
          "Exit"
        ));
        switch (choice) {
          case 0 -> patientService.create(sc);
          case 1 -> patientService.update(sc);
          case 2 -> patientService.destroy(sc);
          case 3 -> patientService.findById(sc);
          case 4 -> patientService.findAll();
          case 5 -> patientService.findAllByPage(sc);
          case 6 -> patientService.count();
          default -> Policies.exist("exit");
        }
      } catch (Exception e) {
        Printer.alert(Objects.isNull(e.getMessage()) ? "" : e.getMessage());
      }
    }
  }

  public static void main(String[] args) {
    HospitalInformationSystemCLI cli = new HospitalInformationSystemCLI();
    cli.start();
  }
}