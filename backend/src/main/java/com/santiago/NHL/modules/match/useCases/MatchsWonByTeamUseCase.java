package com.santiago.NHL.modules.match.useCases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;

@Service
public class MatchsWonByTeamUseCase {

  @Autowired
  MatchRepository repository;

  public List<MatchDTO> execute(String team) {
    List<MatchEntity> rawMatchs = repository.findAllMatchesWonByTeam(team);
    List<MatchDTO> matchs = new ArrayList<>();

    rawMatchs.stream().forEach(m -> {
      matchs.add(MatchDTO.map(m));
    });

    return matchs;
  }
}
