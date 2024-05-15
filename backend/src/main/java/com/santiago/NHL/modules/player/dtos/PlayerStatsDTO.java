package com.santiago.NHL.modules.player.dtos;

import java.util.UUID;

import com.santiago.NHL.modules.game.dtos.GameDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsDTO {

  private UUID id;
  private int points;
  private int minutes_played;
  private GameDTO game;
  private PlayerDTO player;

}
