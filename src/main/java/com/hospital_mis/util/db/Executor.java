package com.hospital_mis.util.db;

import com.hospital_mis.exception.ORMException;
import com.hospital_mis.util.Logger.SystemLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Executor {

  private Executor() {}

  public static ResultSet executeQuery(String sqlQuery) throws ORMException {
    try (Connection connection = Connector.getConnection()) {
      Statement statement = connection.createStatement();

      return statement.executeQuery(sqlQuery);
    }
    catch (Exception e) {
      SystemLogger.getLogger().error("Error while executing query-<{}> ~ {}", sqlQuery, e.getMessage());
      throw new ORMException(e.getMessage());
    }
  }
}
