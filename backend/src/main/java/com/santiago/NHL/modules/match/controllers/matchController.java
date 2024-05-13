package com.santiago.NHL.modules.match.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.useCases.GetMatchesByMVPPlayerUseCase;
import com.santiago.NHL.modules.match.useCases.GetMatchesUseCase;
import com.santiago.NHL.modules.match.useCases.MatchsWonByTeamUseCase;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {

  @Autowired
  private MatchsWonByTeamUseCase matchesWonByTeamUseCase;

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

  @GetMapping("/{id}")
  public ResponseEntity<MatchDTO> getMatch(@PathVariable String id) {
    MatchDTO results = getMatchesUseCase.byId(id);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/mvp/{id}")
  public List<MatchDTO> getAllMvpMatches(@PathVariable String id) {
    var results = getMatchesByMVPPlayerUseCase.execute(id);
    return results;
  }
}
