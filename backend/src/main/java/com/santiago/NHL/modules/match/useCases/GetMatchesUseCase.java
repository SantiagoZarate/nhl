package com.santiago.NHL.modules.match.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;

@Service
public class GetMatchesUseCase {

  @Autowired
  MatchRepository repository;

  public List<MatchDTO> execute() {
    List<MatchEntity> rawMatchs = repository.findAll();
    return MatchDTO.mapList(rawMatchs);
  }

  public List<MatchDTO> byTeam(String team, int limit) {
    List<MatchEntity> rawMatchs = repository.findAllByTeam(team, limit);
    return MatchDTO.mapList(rawMatchs);
  }

  public List<MatchEntity> latests() {
    return repository.findAllMatchesSortedByDate();
  }
}
