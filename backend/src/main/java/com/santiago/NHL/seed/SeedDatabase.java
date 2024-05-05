package com.santiago.NHL.seed;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SeedDatabase {

  private final JdbcTemplate jdbcTemplate;

  public SeedDatabase(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public static void main(String[] args) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("org.postgresql.Driver");
    dataSource.setUsername("root");
    dataSource.setPassword("rootpass");

    SeedDatabase populate = new SeedDatabase(dataSource);
    populate.run(args);
  }

  private void run(String... args) {
    executeSqlFile("backend/src/main/resources/sql/init.sql");
  }

  private void executeSqlFile(String filePath) {
    try {
      String query = new String(Files.readAllBytes(Paths.get(filePath)));
      jdbcTemplate.execute(query);
      System.out.println("Ejecutando query...");
    } catch (IOException e) {
      System.out.println("Error while trying to fech sql query " + e.getMessage());
    }
  }

}
