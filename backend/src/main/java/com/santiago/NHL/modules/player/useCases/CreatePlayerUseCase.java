package com.santiago.NHL.modules.player.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

@Service
public class CreatePlayerUseCase {

  @Autowired
  private PlayerRepository repository;

  // public PlayerEntity execute(String name, String teamName) {
  // PlayerEntity result = repository.save(new PlayerEntity(UUID.randomUUID(),
  // name));
  // return result;
  // }

  public PlayerEntity execute(String name) {
    System.out.println(name);
    PlayerEntity result = repository.save(new PlayerEntity(UUID.randomUUID(), name));
    return result;
  }
}
