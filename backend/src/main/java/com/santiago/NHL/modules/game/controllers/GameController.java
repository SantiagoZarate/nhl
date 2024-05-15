package com.santiago.NHL.modules.game.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.game.useCases.GetMatchesByMVPPlayerUseCase;
import com.santiago.NHL.modules.game.useCases.GetMatchesUseCase;
import com.santiago.NHL.modules.game.useCases.MatchsWonByTeamUseCase;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

  @Autowired
  private MatchsWonByTeamUseCase matchesWonByTeamUseCase;

  @Autowired
  private GetMatchesUseCase getMatchesUseCase;

  @Autowired
  private GetMatchesByMVPPlayerUseCase getMatchesByMVPPlayerUseCase;

  @GetMapping("")
  public List<GameDTO> getAllMatches() {
    List<GameDTO> results = this.getMatchesUseCase.execute();
    return results;
  }

  @GetMapping("/{team}/win")
  public List<GameDTO> getAllMatchesWin(@PathVariable String team) {
    String teamLowecase = team.toLowerCase();
    var results = matchesWonByTeamUseCase.execute(teamLowecase);
    return results;
  }

  @GetMapping("/{id}")
  public ResponseEntity<GameDTO> getMatch(@PathVariable String id) {
    GameDTO results = getMatchesUseCase.byId(id);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/mvp/{id}")
  public List<GameDTO> getAllMvpMatches(@PathVariable String id) {
    var results = getMatchesByMVPPlayerUseCase.execute(id);
    return results;
  }
}
