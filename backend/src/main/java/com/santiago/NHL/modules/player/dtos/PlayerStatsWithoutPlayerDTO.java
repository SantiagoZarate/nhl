package com.santiago.NHL.modules.player.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.player.entities.PlayerStatsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsWithoutPlayerDTO {

  private UUID id;
  private int points;
  private int minutes_played;
  private GameDTO game;

  public static PlayerStatsWithoutPlayerDTO map(PlayerStatsEntity stats) {
    return PlayerStatsWithoutPlayerDTO
        .builder()
        .id(stats.getId())
        .points(stats.getPoints())
        .game(GameDTO.map(stats.getGameEntity()))
        .minutes_played(stats.getMinutes_played())
        .build();
  }

  public static List<PlayerStatsWithoutPlayerDTO> mapList(List<PlayerStatsEntity> statsList) {
    List<PlayerStatsWithoutPlayerDTO> ret = new ArrayList<>();
    statsList
        .stream()
        .forEach(stat -> ret.add(map(stat)));
    return ret;
  }
}
