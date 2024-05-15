package com.santiago.NHL.modules.game.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.game.entities.GameEntity;
import com.santiago.NHL.modules.game.repositories.GameRepository;

@Service
public class GetMatchesUseCase {

  @Autowired
  GameRepository repository;

  public List<GameDTO> execute() {
    List<GameEntity> rawMatchs = repository.findAll();
    return GameDTO.mapList(rawMatchs);
  }

  public List<GameEntity> latests() {
    return repository.findAllMatchesSortedByDate();
  }

  public GameDTO byId(String id) {
    Optional<GameEntity> matchFound = repository.findById(UUID.fromString(id));
    return GameDTO.map(matchFound.get());
  }
}
