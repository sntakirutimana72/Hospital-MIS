package com.hospital_mis.util.db;

import com.hospital_mis.config.Env;

import org.flywaydb.core.Flyway;

public class Migration {
  private Migration() {}

  public static void migrate() {
    // Configure Flyway
    Flyway flyway = Flyway.configure()
      .dataSource(Env.DB_URL, Env.DB_USER, Env.DB_PASS)
      .locations("filesystem:src/main/resources/com/hospital_mis/db/migrations")
      .load();
    // Migrate the database
    flyway.migrate();
  }
}
