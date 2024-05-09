package com.santiago.NHL.modules.team.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.dtos.TeamDTO;
import com.santiago.NHL.modules.match.useCases.GetMatchesByTeamUseCase;
import com.santiago.NHL.modules.team.useCases.GetTeamsUseCase;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

  @Autowired
  private GetTeamsUseCase getTeamsUseCase;

  @Autowired
  private GetMatchesByTeamUseCase getMatchesByTeamUseCase;

  @GetMapping("")
  public ResponseEntity<List<TeamDTO>> getAllTeams() {
    List<TeamDTO> results = getTeamsUseCase.execute();
    return ResponseEntity.ok(results);
  }

  @GetMapping("/{name}")
  public ResponseEntity<TeamDTO> getTeam(@PathVariable String name) {
    TeamDTO results = getTeamsUseCase.byName(name);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/{name}/matches")
  public ResponseEntity<List<MatchDTO>> getAllMatchsByTeam(@PathVariable String name) {
    List<MatchDTO> results = getMatchesByTeamUseCase.execute(name, 10);
    return ResponseEntity.ok(results);
  }
}
