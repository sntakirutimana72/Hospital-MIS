package com.hospital_mis.service;

import com.hospital_mis.exception.AbortException;
import com.hospital_mis.exception.ORMException;
import com.hospital_mis.exception.RecordNotFoundException;
import com.hospital_mis.model.Patient;
import com.hospital_mis.repository.Repository;
import com.hospital_mis.util.Printer;
import com.hospital_mis.util.UserPrompt;
import com.hospital_mis.util.validator.PatientValidator;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PatientService {
  private final Repository<Patient> patientRepository;

  public PatientService(Repository<Patient> patientRepository) {
    this.patientRepository = patientRepository;
  }

  public void create(Scanner sc) throws AbortException, ORMException {
    String name = UserPrompt.getText(sc, "Enter name:\n> ", PatientValidator::validateNameOrSurname);
    String surname = UserPrompt.getText(sc, "Enter surname:\n> ", PatientValidator::validateNameOrSurname);
    String address = UserPrompt.getText(sc, "Enter address:\n> ", PatientValidator::validateAddress);
    String phone = UserPrompt.getText(sc, "Enter phone:\n> ", PatientValidator::validatePhone);

    int id = patientRepository.create(new Patient(0, name, surname, address, phone));

    Printer.alert(String.format("Patient ID~%d was successfully created!", id));
  }

  public void update(Scanner sc) throws AbortException, ORMException {
    Patient entity = UserPrompt.selectPatient("patient", sc, patientRepository.findAll());
    String name = UserPrompt.getText(sc,
      String.format("Enter name (`%s`):\n> ", entity.getName()), PatientValidator::validateNameOrSurname);
    String surname = UserPrompt.getText(sc,
      String.format("Enter surname (`%s`):\n> ", entity.getSurname()), PatientValidator::validateNameOrSurname);
    String address = UserPrompt.getText(sc,
      String.format("Enter address (`%s`):\n> ", entity.getAddress()), PatientValidator::validateAddress);
    String phone = UserPrompt.getText(sc,
      String.format("Enter phone (`%s`):\n> ", entity.getPhone()), PatientValidator::validatePhone);

    boolean success = patientRepository.update(new Patient(entity.getId(), name, surname, address, phone));
    if (success)
      Printer.alert(String.format("Patient with ID~%s was successfully updated!", entity.getId()));
    else
      Printer.alert("Something went wrong while updating patient~" + entity.getId());
  }

  public void destroy(Scanner sc) throws ORMException, AbortException {
    Patient entity = UserPrompt.selectPatient("patient", sc, patientRepository.findAll());
    boolean success = patientRepository.destroy(entity.getId());
    if (success)
      Printer.alert(String.format("Patient with ID~%s was successfully deleted!", entity.getId()));
    else
      Printer.alert("Something went wrong while deleting patient~" + entity.getId());
  }

  public void findById(Scanner sc) throws AbortException, RecordNotFoundException, ORMException {
    int searchId = UserPrompt.getPositiveInt(sc, "Enter id:\n> ", 1);
    Patient entity = patientRepository.findById(searchId);
    Printer.tabular(
      String.format("Record Found - Search ID~%s", searchId),
      List.of("ID", "Name", "Surname", "Address", "Phone"),
      List.of(List.of(
        String.valueOf(entity.getId()), entity.getName(), entity.getSurname(), entity.getAddress(), entity.getPhone())
      ));
  }

  private void populateRecords(List<Patient> records) {
    if (Objects.isNull(records) || records.isEmpty())
      throw new IllegalArgumentException("No patient records found");
    Printer.tabular(
      "List of All Patients",
      List.of("ID", "Name", "Surname", "Address", "Phone"),
      records.stream().map(e -> List.of(
        String.valueOf(e.getId()),
        e.getName(),
        e.getSurname(),
        e.getAddress(),
        e.getPhone()
      )).toList()
    );
  }

  public void findAll() throws ORMException {
    List<Patient> records = patientRepository.findAll();
    populateRecords(records);
  }

  public void findAllByPage(Scanner sc) throws AbortException, ORMException {
    int page = UserPrompt.getPositiveInt(sc, "Enter search page:\n> ", 1);
    List<Patient> records = patientRepository.findAllByPage(page);
    populateRecords(records);
  }

  public void count() throws ORMException {
    int counter = patientRepository.count();
    Printer.alert("Counted " + counter + " Patient" + (counter > 1 ? "s" : ""));
  }
}