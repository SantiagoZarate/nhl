package com.santiago.NHL.modules.game.useCases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.game.entities.GameEntity;
import com.santiago.NHL.modules.game.repositories.GameRepository;

@Service
public class MatchsWonByTeamUseCase {

  @Autowired
  GameRepository repository;

  public List<GameDTO> execute(String team) {
    List<GameEntity> rawMatchs = repository.findAllMatchesWonByTeam(team);
    List<GameDTO> matchs = new ArrayList<>();

    rawMatchs.stream().forEach(m -> {
      matchs.add(GameDTO.map(m));
    });

    return matchs;
  }
}
