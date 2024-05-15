package com.santiago.NHL.modules.player.dtos.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.santiago.NHL.modules.game.dtos.GameDTO;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.dtos.PlayerStatsDTO;
import com.santiago.NHL.modules.player.entities.PlayerStatsEntity;

public class PlayerStatsMapper {

  public static PlayerStatsDTO map(PlayerStatsEntity stats) {
    return PlayerStatsDTO
        .builder()
        .id(stats.getId())
        .game(GameDTO.map(stats.getGameEntity()))
        .player(PlayerDTO.map(stats.getPlayerEntity()))
        .points(stats.getPoints())
        .minutes_played(stats.getMinutes_played())
        .build();
  }

  public static List<PlayerStatsDTO> mapList(List<PlayerStatsEntity> statsList) {
    return statsList.stream()
        .map(PlayerStatsMapper::map)
        .collect(Collectors.toList());
  }

}
