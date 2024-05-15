package com.santiago.NHL.modules.game.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.game.entities.GameEntity;
import com.santiago.NHL.modules.game.repositories.GameRepository;

@Service
public class GetMatchesByMVPPlayerUseCase {

  @Autowired
  private GameRepository repository;

  public List<GameDTO> execute(String mvp) {
    List<GameEntity> matchs = repository.findAllMvpMatches(mvp);
    return GameDTO.mapList(matchs);
  };
}
