package com.santiago.NHL.modules.player.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.santiago.NHL.modules.player.entities.PlayerEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryTests {

  @Autowired
  private PlayerRepository repository;

  @Test
  @DisplayName("Get player by id")
  public void getPlayerByIdTest() {
    UUID id = new UUID(0, 0);
    PlayerEntity p = PlayerEntity.builder().id(id).build();

    PlayerEntity savedPlayer = repository.save(p);

    assertEquals(savedPlayer.getId(), id);
  }
}
