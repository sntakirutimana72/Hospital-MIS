package com.hospital_mis.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {

  private Env() {}

  private static final Dotenv dotenv = Dotenv.configure()
    .filename(".env.local")
    .load();

  public static final String DB_URL = dotenv.get("DB_URL"),
                             DB_USER = dotenv.get("DB_USER"),
                             DB_PASS = dotenv.get("DB_PASS");
}
