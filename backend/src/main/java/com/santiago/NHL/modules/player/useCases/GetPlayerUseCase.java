package com.santiago.NHL.modules.player.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

@Service
public class GetPlayerUseCase {

  @Autowired
  private PlayerRepository repository;

  public List<PlayerDTO> execute() {
    List<PlayerEntity> rawPlayers = repository.findAll();
    List<PlayerDTO> playersList = new ArrayList<>();

    rawPlayers.stream().forEach(p -> {
      playersList.add(PlayerDTO.map(p));
    });

    return playersList;
  }

  public PlayerDTO byId(UUID id) throws Exception {
    Optional<PlayerEntity> player = repository.findById(id);
    return PlayerDTO.map(player.get());
  }
}
