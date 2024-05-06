package com.santiago.NHL.modules.player.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.useCases.GetPlayerUseCase;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {

  @Autowired
  private GetPlayerUseCase getPlayerUseCase;

  @GetMapping("")
  public List<PlayerEntity> getAllPlayers() {
    var results = getPlayerUseCase.execute();
    return results;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getPlayerById(@PathVariable String id) {
    UUID playerId = UUID.fromString(id);
    Optional<PlayerEntity> results = getPlayerUseCase.byId(playerId);

    if (!results.isPresent()) {
      String message = "Player with ID " + id + " not found";
      Map<String, String> response = new HashMap<>();
      response.put("message", message);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    return ResponseEntity.ok(results.get());
  }

}
