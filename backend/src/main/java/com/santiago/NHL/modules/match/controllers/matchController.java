package com.santiago.NHL.modules.match.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.useCases.GetAllMatchesSortedByDateUseCase;
import com.santiago.NHL.modules.match.useCases.MatchesWonByTeamUseCase;

@RestController
@RequestMapping("/api/v1/match")
public class matchController {

  @Autowired
  private MatchesWonByTeamUseCase matchesWonByTeamUseCase;

  @Autowired
  private GetAllMatchesSortedByDateUseCase getAllMatchesSortedByDateUseCase;

  @GetMapping("")
  public List<MatchEntity> getAllMatches() {
    List<MatchEntity> results = this.getAllMatchesSortedByDateUseCase.execute();
    return results;
  }

  @GetMapping("/{team}")
  public List<MatchEntity> getAllMatchesWin(@PathVariable String team) {
    var results = matchesWonByTeamUseCase.execute(team);
    return results;
  }
}
