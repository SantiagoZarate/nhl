package com.santiago.NHL.modules.match.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;

@Service
public class GetMatchesUseCase {

  @Autowired
  MatchRepository repository;

  public List<MatchEntity> execute() {
    return repository.findAll();
  }

  public List<MatchEntity> byTeam(String team, int limit) {
    return repository.findAllByTeam(team, limit);
  }

  public List<MatchEntity> latests() {
    return repository.findAllMatchesSortedByDate();
  }
}
