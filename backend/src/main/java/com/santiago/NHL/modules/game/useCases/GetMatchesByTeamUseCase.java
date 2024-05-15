package com.santiago.NHL.modules.game.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.game.entities.GameEntity;
import com.santiago.NHL.modules.game.repositories.GameRepository;

@Service
public class GetMatchesByTeamUseCase {

  @Autowired
  private GameRepository repository;

  public List<GameDTO> execute(String team, int limit) {
    List<GameEntity> rawMatchs = repository.findAllByTeam(team, limit);
    return GameDTO.mapList(rawMatchs);
  }
}
