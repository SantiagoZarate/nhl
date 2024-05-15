package com.santiago.NHL.modules.player.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.player.entities.PlayerStatsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStatsWithoutGameDTO {

  private UUID id;
  private int points;
  private int minutes_played;
  private PlayerDTO player;

  public static PlayerStatsWithoutGameDTO map(PlayerStatsEntity stats) {
    return PlayerStatsWithoutGameDTO
        .builder()
        .id(stats.getId())
        .points(stats.getPoints())
        .player(PlayerDTO.map(stats.getPlayerEntity()))
        .minutes_played(stats.getMinutes_played())
        .build();
  }

  public static List<PlayerStatsWithoutGameDTO> mapList(List<PlayerStatsEntity> statsList) {
    List<PlayerStatsWithoutGameDTO> ret = new ArrayList<>();
    statsList
        .stream()
        .forEach(stat -> ret.add(map(stat)));
    return ret;
  }
}
