package com.santiago.NHL.modules.match.useCases;

import java.util.ArrayList;
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
    List<MatchDTO> matches = new ArrayList<>();

    rawMatchs.stream().forEach(m -> {
      var match = MatchDTO.builder()
          .id(m.getId())
          .guest_team(m.getGuest_team())
          .home_team(m.getHost_team())
          .winner(m.getWinner())
          .score(m.getScore())
          .mvp_player(m.getPlayerEntity().getName())
          .build();

      matches.add(match);
    });

    return matches;
  }

  public List<MatchEntity> byTeam(String team, int limit) {
    return repository.findAllByTeam(team, limit);
  }

  public List<MatchEntity> latests() {
    return repository.findAllMatchesSortedByDate();
  }
}
