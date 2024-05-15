package com.santiago.NHL.modules.player.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.player.dtos.PlayerStatsDTO;
import com.santiago.NHL.modules.player.dtos.PlayerStatsWithoutGameDTO;
import com.santiago.NHL.modules.player.dtos.PlayerStatsWithoutPlayerDTO;
import com.santiago.NHL.modules.player.useCases.GetPlayerStatsUseCase;

@RestController
@RequestMapping("/api/v1/player_stats")
public class PlayerStatsController {

  @Autowired
  private GetPlayerStatsUseCase getPlayerStatsUseCase;

  @GetMapping
  private ResponseEntity<List<PlayerStatsDTO>> getAll() {
    List<PlayerStatsDTO> results = getPlayerStatsUseCase.execute();
    return ResponseEntity.ok(results);
  }

  @GetMapping("/player/{playerID}")
  public ResponseEntity<List<PlayerStatsWithoutPlayerDTO>> allByPlayer(@PathVariable String playerID) {
    List<PlayerStatsWithoutPlayerDTO> results = getPlayerStatsUseCase.byPlayer(playerID);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/game/{gameID}")
  public ResponseEntity<List<PlayerStatsWithoutGameDTO>> allByGame(@PathVariable String gameID) {
    List<PlayerStatsWithoutGameDTO> results = getPlayerStatsUseCase.byGame(gameID);
    return ResponseEntity.ok(results);
  }
}
