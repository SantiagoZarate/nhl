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

import com.santiago.NHL.modules.game.dtos.ResponseDTO;
import com.santiago.NHL.modules.game.useCases.GetMatchesByPlayerUseCase;
import com.santiago.NHL.modules.player.dtos.CreateInjuryDTO;
import com.santiago.NHL.modules.player.dtos.CreatePlayerDTO;
import com.santiago.NHL.modules.player.dtos.CreateSkillsDTO;
import com.santiago.NHL.modules.player.dtos.InjuryDTO;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.dtos.PlayerWithTeamDTO;
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
  private CreateSkillsForPlayerUseCase createSkillsForPlayerUseCase;

  @Autowired
  private CreateInjuryForPlayerUseCase createInjuryUseCase;

  @Autowired
  private GetMatchesByPlayerUseCase getMatchesByPlayerUseCase;

  @GetMapping("")
  public ResponseEntity<ResponseDTO<PlayerWithTeamDTO>> getAllPlayers(
      @RequestParam(name = "limit", defaultValue = "10") String limit,
      @RequestParam(name = "skip", defaultValue = "0") String skip) {

    List<PlayerWithTeamDTO> results = getPlayerUseCase.execute(Integer.parseInt(limit), Integer.parseInt(skip));
    ResponseDTO<PlayerWithTeamDTO> players = new ResponseDTO<>(results, skip, limit, results.size());
    return ResponseEntity.ok(players);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PlayerWithTeamDTO> getPlayerById(@PathVariable String id) throws Exception {
    UUID playerId = UUID.fromString(id);
    PlayerWithTeamDTO results = getPlayerUseCase.byId(playerId);
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

  @GetMapping("/{id}/matches")
  // public ResponseEntity<List<PlayerMatchEntity>>
  // getMatchesByPlayer(@PathVariable String id) {
  public void getMatchesByPlayer(@PathVariable String id) {
    // List<PlayerMatchEntity> results =
    getMatchesByPlayerUseCase.execute(id);
    // return ResponseEntity.ok(results);
  }

  @PostMapping("")
  public ResponseEntity<?> postPlayer(@RequestBody CreatePlayerDTO dto) {
    PlayerEntity result = createPlayerUseCase.execute(dto);
    return ResponseEntity.ok(result);
  }

  @PostMapping("/{id}/skill")
  public ResponseEntity<?> postSkills(@PathVariable String id, @RequestBody CreateSkillsDTO dto) {
    PlayerDTO results = createSkillsForPlayerUseCase.execute(id, dto);
    return ResponseEntity.ok(results);
  }

  @PostMapping("/{id}/injuries")
  public ResponseEntity<?> postInjury(@PathVariable String id, @RequestBody CreateInjuryDTO dto) {
    InjuryDTO results = createInjuryUseCase.execute(id, dto);
    return ResponseEntity.ok(results);
  }

}
