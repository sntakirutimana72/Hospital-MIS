package com.hospital_mis.repository;

import com.hospital_mis.config.Env;
import com.hospital_mis.exception.ORMException;
import com.hospital_mis.exception.RecordNotFoundException;
import com.hospital_mis.model.Patient;
import com.hospital_mis.util.Logger.SystemLogger;
import com.hospital_mis.util.db.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements Repository<Patient> {
  @Override
  public int create(Patient patient) throws ORMException {
    String sqlQuery = "INSERT INTO patients (name, surname, address, phone) VALUES (?, ?, ?, ?)";
    try(
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)
    ) {
      stmt.setString(1, patient.getName());
      stmt.setString(2, patient.getSurname());
      stmt.setString(3, patient.getAddress());
      stmt.setString(4, patient.getPhone());

      stmt.executeUpdate();

      try (ResultSet keys = stmt.getGeneratedKeys()) {
        if (keys.next()) {
          return keys.getInt(1);
        }
        throw new ORMException("Insert succeeded but no ID returned.");
      }
    }
    catch (SQLException e) {
      SystemLogger.getLogger().error("Error while creating new patient record - {}", e.getMessage());
      throw new ORMException("Error occurred while creating new patient record - " + e.getMessage());
    }
  }

  @Override
  public boolean update(Patient patient) throws ORMException {
    String sqlQuery = "UPDATE patients SET name = ?, surname = ?, address = ?, phone = ? WHERE id = ?";

    try (
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sqlQuery)
    ) {
      stmt.setString(1, patient.getName());
      stmt.setString(2, patient.getSurname());
      stmt.setString(3, patient.getAddress());
      stmt.setString(4, patient.getPhone());
      stmt.setInt(5, patient.getId());

      return stmt.executeUpdate() == 0;
    } catch (SQLException e) {
      SystemLogger.getLogger().error("Error while updating patient~{} - {}", patient.getId(), e.getMessage());
      throw new ORMException(e.getMessage());
    }
  }

  @Override
  public boolean destroy(int id) throws ORMException {
    try (
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement("DELETE FROM patients WHERE id = ?")
    ) {
      stmt.setInt(1, id);

      return stmt.executeUpdate() == 1;
    } catch (SQLException e) {
      SystemLogger.getLogger().error("Error while deleting patient~{} - {}", id, e.getMessage());
      throw new ORMException(e.getMessage());
    }
  }

  @Override
  public Patient findById(int id) throws RecordNotFoundException, ORMException {
    String sqlQuery = "SELECT id, name, surname, address, phone FROM patients WHERE id = ?";

    try (
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement(sqlQuery)
    ) {
      stmt.setInt(1, id);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return new Patient(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("surname"),
            rs.getString("address"),
            rs.getString("phone")
          );
        } else
          throw new RecordNotFoundException("Patient with ID~" + id);
      }
    } catch (SQLException e) {
      SystemLogger.getLogger().error("Error while selecting patient~{} - {}", id, e.getMessage());
      throw new ORMException("Error occurred while querying record. Please try again");
    }
  }

  @Override
  public int count() throws ORMException {
    try (
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM patients");
      ResultSet rs = stmt.executeQuery()
    ) {
      return rs.next() ? rs.getInt(1) : 0;
    } catch (SQLException e) {
      SystemLogger.getLogger().error("Error while performing count on patients - {}", e.getMessage());
      throw new ORMException("Error occurred while counting patients");
    }
  }

  @Override
  public List<Patient> findAll() throws ORMException {
    try (
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement("SELECT id, name, surname, address, phone FROM patients");
      ResultSet rs = stmt.executeQuery()
    ) {
      List<Patient> patients = new ArrayList<>();
      while (rs.next()) {
        patients.add(new Patient(
          rs.getInt("id"),
          rs.getString("name"),
          rs.getString("surname"),
          rs.getString("address"),
          rs.getString("phone")
        ));
      }
      return patients;
    } catch (SQLException e) {
      SystemLogger.getLogger().error("Error in patients findAll() - {}", e.getMessage());
      throw new ORMException("Error occurred while fetching patients. Please try again");
    }
  }

  @Override
  public List<Patient> findAllByPage(int page) throws ORMException {
    int offset = (page - 1) * Env.QUERY_MAX_NUM_PER_PAGE;

    try (
      Connection conn = Connector.getConnection();
      PreparedStatement stmt = conn.prepareStatement("SELECT id, name, surname, address, phone FROM patients LIMIT ? OFFSET ?")
    ) {
      stmt.setInt(1, Env.QUERY_MAX_NUM_PER_PAGE);
      stmt.setInt(2, offset);

      try (ResultSet rs = stmt.executeQuery()) {
        List<Patient> patients = new ArrayList<>();
        while (rs.next()) {
          patients.add(new Patient(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("surname"),
            rs.getString("address"),
            rs.getString("phone")
          ));
        }
        return patients;
      }
    } catch (SQLException e) {
      SystemLogger.getLogger().error("Error in patients findAllByPage() - {}", e.getMessage());
      throw new ORMException("Error occurred while fetching patients. Please try again");
    }
  }
}
