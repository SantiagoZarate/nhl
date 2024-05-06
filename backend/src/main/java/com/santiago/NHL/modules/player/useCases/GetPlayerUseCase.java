package com.santiago.NHL.modules.player.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

@Service
public class GetPlayerUseCase {

  @Autowired
  private PlayerRepository repository;

  public List<PlayerEntity> execute() {
    return repository.findAll();
  }

  public Optional<PlayerEntity> byId(UUID id) {
    return repository.findById(id);
  }
}
