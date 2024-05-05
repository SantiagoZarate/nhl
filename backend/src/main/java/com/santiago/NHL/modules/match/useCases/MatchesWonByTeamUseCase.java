package com.santiago.NHL.modules.match.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;

@Service
public class MatchesWonByTeamUseCase {

  @Autowired
  MatchRepository repository;

  public List<MatchEntity> execute(String team) {
    List<MatchEntity> matchs = repository.findAllMatchesWonByTeam(team);
    return matchs;
  }
}
