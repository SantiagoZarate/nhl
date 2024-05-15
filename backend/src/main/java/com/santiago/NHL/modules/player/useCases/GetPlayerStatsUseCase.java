package com.santiago.NHL.modules.player.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.PlayerStatsDTO;
import com.santiago.NHL.modules.player.dtos.PlayerStatsWithoutGameDTO;
import com.santiago.NHL.modules.player.dtos.PlayerStatsWithoutPlayerDTO;
import com.santiago.NHL.modules.player.dtos.mapper.PlayerStatsMapper;
import com.santiago.NHL.modules.player.entities.PlayerStatsEntity;
import com.santiago.NHL.modules.player.repositories.PlayerStatsRepository;

@Service
public class GetPlayerStatsUseCase {

  @Autowired
  private PlayerStatsRepository repository;

  public List<PlayerStatsDTO> execute() {
    List<PlayerStatsEntity> playerStats = repository.findAll();
    return PlayerStatsMapper.mapList(playerStats);
  }

  public PlayerStatsDTO byID(String id) {
    Optional<PlayerStatsEntity> playerFound = repository.findById(UUID.fromString(id));
    return PlayerStatsMapper.map(playerFound.get());
  }

  public List<PlayerStatsWithoutPlayerDTO> byPlayer(String playerID) {
    List<PlayerStatsEntity> playerStats = repository.findByPlayer(UUID.fromString(playerID));
    return PlayerStatsWithoutPlayerDTO.mapList(playerStats);
  }

  public List<PlayerStatsWithoutGameDTO> byGame(String gameID) {
    List<PlayerStatsEntity> gameStats = repository.findByGame(UUID.fromString(gameID));
    return PlayerStatsWithoutGameDTO.mapList(gameStats);
  }

}
