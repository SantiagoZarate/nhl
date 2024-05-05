package com.santiago.NHL.modules.match.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.useCases.GetMatchesUseCase;
import com.santiago.NHL.modules.match.useCases.MatchesWonByTeamUseCase;

@RestController
@RequestMapping("/api/v1/match")
public class matchController {

  @Autowired
  private MatchesWonByTeamUseCase matchesWonByTeamUseCase;

  @Autowired
  private GetMatchesUseCase getMatchesUseCase;

  @GetMapping("")
  public List<MatchEntity> getAllMatches() {
    List<MatchEntity> results = this.getMatchesUseCase.execute();
    return results;
  }

  @GetMapping("/{team}/win")
  public List<MatchEntity> getAllMatchesWin(@PathVariable String team) {
    var results = matchesWonByTeamUseCase.execute(team);
    return results;
  }

  @GetMapping("/{team}")
  public List<MatchEntity> getMatchesByTeam(@PathVariable String team,
      @RequestParam(name = "limit", required = false, defaultValue = "10") String limit) {
    String teamLowercase = team.toLowerCase();
    var results = getMatchesUseCase.byTeam(teamLowercase, Integer.parseInt(limit));
    return results;
  }
}
