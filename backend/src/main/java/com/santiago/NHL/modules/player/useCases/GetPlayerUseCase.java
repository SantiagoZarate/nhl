package com.santiago.NHL.modules.player.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.dtos.PlayerWithTeamDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

@Service
public class GetPlayerUseCase {

  @Autowired
  private PlayerRepository repository;

  public List<PlayerWithTeamDTO> execute(int limit, int skip) {
    List<PlayerEntity> rawPlayers = repository.findAll(limit, skip);
    return PlayerWithTeamDTO.mapListWithTeam(rawPlayers);
  }

  public PlayerDTO byId(UUID id) throws Exception {
    Optional<PlayerEntity> player = repository.findById(id);
    return PlayerDTO.map(player.get());
  }

  public List<PlayerDTO> byName(String name) {
    List<PlayerEntity> foundPlayers = repository.findByName(name);
    return PlayerDTO.mapList(foundPlayers);
  }

  public List<PlayerDTO> byTeam(String name) {
    List<PlayerEntity> foundPlayers = repository.findByTeam(name);
    return PlayerDTO.mapList(foundPlayers);
  }
}
