package com.hospital_mis.util.db;

import com.hospital_mis.config.Env;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class Connector {
  private static final HikariDataSource source;

  static {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(Env.DB_URL);
    config.setUsername(Env.DB_USER);
    config.setPassword(Env.DB_PASS);
    config.setMaximumPoolSize(10); // Pool size
    source = new HikariDataSource(config);
  }

  private Connector() {}

  public static Connection getConnection() throws SQLException {
    return source.getConnection();
  }
}
