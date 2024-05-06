package com.santiago.NHL.modules.player.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.useCases.GetPlayerUseCase;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

  @Autowired
  private GetPlayerUseCase getPlayerUseCase;

  @GetMapping("")
  public List<PlayerDTO> getAllPlayers() {
    var results = getPlayerUseCase.execute();
    return results;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPlayerById(@PathVariable String id) throws Exception {
    UUID playerId = UUID.fromString(id);
    PlayerDTO results = getPlayerUseCase.byId(playerId);
    return ResponseEntity.ok(results);
  }
}
