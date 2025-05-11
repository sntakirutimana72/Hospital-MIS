module com.hospital_mis {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.bootstrapfx.core;
  requires com.zaxxer.hikari;
  requires java.sql;
  requires org.slf4j;
  requires static lombok;
  requires io.github.cdimascio.dotenv.java;
  requires org.flywaydb.core;

  opens com.hospital_mis to javafx.fxml;
  exports com.hospital_mis;
}