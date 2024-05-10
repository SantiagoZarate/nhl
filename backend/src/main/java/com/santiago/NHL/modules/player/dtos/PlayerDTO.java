package com.santiago.NHL.modules.player.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.match.dtos.TeamDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerDTO {

  private UUID id;
  private String name;
  private TeamDTO team;

  public static PlayerDTO map(PlayerEntity p) {
    TeamEntity team = p.getTeamEntity();
    TeamDTO teamDTO = TeamDTO
        .builder()
        .name(team.getName())
        .image_url(team.getLogo_url())
        .captain(team.getCaptain().getName())
        .build();

    PlayerDTO newPlayer = PlayerDTO
        .builder()
        .id(p.getId())
        .name(p.getName())
        .team(teamDTO)
        .build();

    return newPlayer;
  }

  public static List<PlayerDTO> mapList(List<PlayerEntity> players) {
    List<PlayerDTO> playersDTO = new ArrayList<>();

    players.stream().forEach(p -> {
      playersDTO.add(map(p));
    });

    return playersDTO;
  }
}
