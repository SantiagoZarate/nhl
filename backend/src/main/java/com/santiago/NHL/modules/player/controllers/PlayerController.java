package com.santiago.NHL.modules.player.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.dtos.ResponseDTO;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.useCases.CreatePlayerUseCase;
import com.santiago.NHL.modules.player.useCases.GetPlayerUseCase;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

  @Autowired
  private GetPlayerUseCase getPlayerUseCase;

  @Autowired
  private CreatePlayerUseCase createPlayerUseCase;

  @GetMapping("")
  public ResponseEntity<ResponseDTO<PlayerDTO>> getAllPlayers(
      @RequestParam(name = "limit", defaultValue = "10") String limit,
      @RequestParam(name = "skip", defaultValue = "0") String skip) {

    List<PlayerDTO> results = getPlayerUseCase.execute(Integer.parseInt(limit), Integer.parseInt(skip));
    ResponseDTO<PlayerDTO> players = new ResponseDTO<>(results, skip, limit);
    return ResponseEntity.ok(players);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPlayerById(@PathVariable String id) throws Exception {
    UUID playerId = UUID.fromString(id);
    PlayerDTO results = getPlayerUseCase.byId(playerId);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<?> getPlayerByName(@PathVariable String name) throws Exception {
    List<PlayerDTO> results = getPlayerUseCase.byName(name);
    return ResponseEntity.ok(results);
  }

  @GetMapping("/team/{team}")
  public ResponseEntity<?> getPlayerByTeam(@PathVariable String team) throws Exception {
    List<PlayerDTO> results = getPlayerUseCase.byTeam(team);
    return ResponseEntity.ok(results);
  }

  @PostMapping("")
  public ResponseEntity<?> postPlayer(@RequestParam String name) {
    PlayerEntity result = createPlayerUseCase.execute(name);
    return ResponseEntity.ok(result);
  }

}
