package com.santiago.NHL.modules.team.useCases;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.dtos.TeamDTO;
import com.santiago.NHL.modules.team.entities.TeamEntity;
import com.santiago.NHL.modules.team.repositories.TeamRepository;

@Service
public class GetTeamsUseCase {

  @Autowired
  private TeamRepository repository;

  public List<TeamDTO> execute() {
    List<TeamEntity> teams = repository.findAll();
    return TeamDTO.mapList(teams);
  }

  public TeamDTO byName(String name) {
    String capitalizeName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    Optional<TeamEntity> team = repository.findById(capitalizeName);
    return TeamDTO.map(team.get());
  }
}
