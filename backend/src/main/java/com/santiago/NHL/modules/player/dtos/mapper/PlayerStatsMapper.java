package com.santiago.NHL.modules.player.dtos.mapper;

import java.util.ArrayList;
import java.util.List;

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
    List<PlayerStatsDTO> newStatsList = new ArrayList<>();

    statsList.stream().forEach(stat -> {
      newStatsList.add(map(stat));
    });

    return newStatsList;
  }

}
