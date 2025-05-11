package com.hospital_mis.util.Logger;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemLogger {
  private SystemLogger() {}

  @Getter
  private static final Logger logger = LoggerFactory.getLogger(SystemLogger.class);
}