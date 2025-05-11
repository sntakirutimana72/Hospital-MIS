package com.hospital_mis.config;

import io.github.cdimascio.dotenv.Dotenv;

public final class Env {

  private Env() {}

  private static final Dotenv dotenv = Dotenv.configure()
    .filename("/src/main/resources/com/hospital_mis/.env.local")
    .load();

  public static final String DB_URL = dotenv.get("DB_URL"),
                             DB_USER = dotenv.get("DB_USER"),
                             DB_PASS = dotenv.get("DB_PASS");
  public static final int QUERY_MAX_NUM_PER_PAGE = Integer.parseInt(dotenv.get("QUERY_MAX_NUM_PER_PAGE", "25"));
}
