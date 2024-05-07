package com.santiago.NHL.modules.match.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.useCases.GetMatchesByMVPPlayerUseCase;
import com.santiago.NHL.modules.match.useCases.GetMatchesUseCase;
import com.santiago.NHL.modules.match.useCases.MatchesWonByTeamUseCase;

@RestController
@RequestMapping("/api/v1/matchs")
public class MatchController {

  @Autowired
  private MatchesWonByTeamUseCase matchesWonByTeamUseCase;

  @Autowired
  private GetMatchesUseCase getMatchesUseCase;

  @Autowired
  private GetMatchesByMVPPlayerUseCase getMatchesByMVPPlayerUseCase;

  @GetMapping("")
  public List<MatchDTO> getAllMatches() {
    List<MatchDTO> results = this.getMatchesUseCase.execute();
    return results;
  }

  @GetMapping("/{team}/win")
  public List<MatchDTO> getAllMatchesWin(@PathVariable String team) {
    String teamLowecase = team.toLowerCase();
    var results = matchesWonByTeamUseCase.execute(teamLowecase);
    return results;
  }

  @GetMapping("/{team}")
  public List<MatchDTO> getMatchesByTeam(@PathVariable String team,
      @RequestParam(name = "limit", required = false, defaultValue = "10") String limit) {
    String teamLowercase = team.toLowerCase();
    var results = getMatchesUseCase.byTeam(teamLowercase, Integer.parseInt(limit));

    return results;
  }

  @GetMapping("/mvp/{id}")
  public List<MatchDTO> getAllMvpMatches(@PathVariable String id) {
    var results = getMatchesByMVPPlayerUseCase.execute(id);
    return results;
  }
}
