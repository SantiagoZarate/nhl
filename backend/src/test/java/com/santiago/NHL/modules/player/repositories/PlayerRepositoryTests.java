package com.santiago.NHL.modules.player.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.santiago.NHL.modules.player.entities.PlayerEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@ContextConfiguration(initializers = PlayerRepositoryTests.DataSourceInitializer.class)
public class PlayerRepositoryTests {

  @Autowired
  private PlayerRepository repository;

  // Use Postgres Docker Image
  @Container
  static final PostgreSQLContainer<?> database = new PostgreSQLContainer<>("postgres:latest").withUsername("postgres");

  static class DataSourceInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    @SuppressWarnings("null")
    public void initialize(ConfigurableApplicationContext appContext) {
      TestPropertySourceUtils.addInlinedPropertiesToEnvironment(appContext,
          "spring.datasource.url=" + database.getJdbcUrl(),
          "spring.datasource.username=" + database.getUsername(),
          "spring.datasource.password=" + database.getPassword(),
          "spring.jpa.hibernate.ddl-auto-create-drop");
    }
  }

  @BeforeEach
  public void setUp() {
    repository.saveAll(List.of(
        new PlayerEntity(UUID.fromString("4e6e6814-fd76-487d-a443-162bd4c8e9a4"), "Marcus"),
        new PlayerEntity(UUID.randomUUID(), "Mario"),
        new PlayerEntity(UUID.randomUUID(), "Santiago")));
  }

  @Test
  @DisplayName("Get all player in the database")
  public void getAllPlayersShouldBe3Test() {
    List<PlayerEntity> players = repository.findAll();
    assertThat(players).hasSize(3);
  }

  @Test
  @DisplayName("Get single player by id")
  public void getPlayerById() {
    // UUID id = new UUID(0, 0);
    // PlayerEntity p = repository.save(new PlayerEntity(id, "Lucas"));
    Optional<PlayerEntity> result = repository.findById(UUID.fromString("4e6e6814-fd76-487d-a443-162bd4c8e9a4"));

    assertThat(result).isPresent();

    PlayerEntity foundPlayer = result.get();
    assertThat(foundPlayer).extracting(PlayerEntity::getId).isEqualTo("4e6e6814-fd76-487d-a443-162bd4c8e9a4");
    assertThat(foundPlayer).extracting(PlayerEntity::getName).isEqualTo("Lucas");
  }

  @Test
  @DisplayName("Get all player matching partial name")
  public void GetPlayersByNameMatchTest() {
    List<PlayerEntity> players = repository.findByName("Mar");

    assertThat(players).hasSize(2);
    assertThat(players).extracting(PlayerEntity::getName).contains("Marcus", "Mario");
  }

  @Disabled
  @Test
  @DisplayName("Get all player by team name")
  public void getPlayersByTeamShoudldBe1Test() {
    List<PlayerEntity> players = repository.findByTeam("Buffalo");
    assertThat(players).hasSize(1);
    assertThat(players).extracting(PlayerEntity::getName).isEqualTo("Marcus");
  }
}
