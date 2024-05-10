package com.santiago.NHL.modules.player.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.match.dtos.ResponseDTO;
import com.santiago.NHL.modules.player.dtos.CreateInjuryDTO;
import com.santiago.NHL.modules.player.dtos.CreatePlayerDTO;
import com.santiago.NHL.modules.player.dtos.CreateSkillsDTO;
import com.santiago.NHL.modules.player.dtos.InjuryDTO;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.useCases.CreateInjuryForPlayerUseCase;
import com.santiago.NHL.modules.player.useCases.CreatePlayerUseCase;
import com.santiago.NHL.modules.player.useCases.CreateSkillsForPlayerUseCase;
import com.santiago.NHL.modules.player.useCases.GetPlayerUseCase;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

  @Autowired
  private GetPlayerUseCase getPlayerUseCase;

  @Autowired
  private CreatePlayerUseCase createPlayerUseCase;

  @Autowired
  private CreateSkillsForPlayerUseCase createSkillsForPlayer;

  @Autowired
  private CreateInjuryForPlayerUseCase createInjuryUseCase;

  @GetMapping("")
  public ResponseEntity<ResponseDTO<PlayerDTO>> getAllPlayers(
      @RequestParam(name = "limit", defaultValue = "10") String limit,
      @RequestParam(name = "skip", defaultValue = "0") String skip) {

    List<PlayerDTO> results = getPlayerUseCase.execute(Integer.parseInt(limit), Integer.parseInt(skip));
    ResponseDTO<PlayerDTO> players = new ResponseDTO<>(results, skip, limit, results.size());
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
  public ResponseEntity<?> postPlayer(@RequestBody CreatePlayerDTO dto) {
    PlayerEntity result = createPlayerUseCase.execute(dto);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/{id}/skill")
  public ResponseEntity<?> postSkills(@PathVariable String id, @RequestBody CreateSkillsDTO dto) {
    PlayerDTO results = createSkillsForPlayer.execute(id, dto);
    return ResponseEntity.ok(results);
  }

  @PostMapping("/{id}/injuries")
  public ResponseEntity<?> postInjury(@PathVariable String id, @RequestBody CreateInjuryDTO dto) {
    InjuryDTO results = createInjuryUseCase.execute(id, dto);
    return ResponseEntity.ok(results);
  }

}
