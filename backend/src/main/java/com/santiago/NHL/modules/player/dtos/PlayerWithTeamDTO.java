package com.santiago.NHL.modules.player.dtos;

import java.util.ArrayList;
import java.util.List;

import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.team.dtos.TeamBareMinimunDTO;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PlayerWithTeamDTO extends PlayerDTO {
  private TeamBareMinimunDTO team;

  public static PlayerWithTeamDTO map(PlayerEntity p) {
    PlayerWithTeamDTO newPlayer = PlayerWithTeamDTO
        .builder()
        .id(p.getId())
        .name(p.getName())
        .nationality(p.getNationality())
        .skill_level(p.getSkill_level())
        .position(p.getPosition())
        .team(extractTeamWithoutPlayers(p.getTeamEntity()))
        .skills(extractSkill(p.getSkills()))
        .injuries(extractInjuries(p.getInjurys()))
        .build();

    return newPlayer;
  }

  public static TeamBareMinimunDTO extractTeamWithoutPlayers(TeamEntity team) {
    if (team == null) {
      return null;
    }

    return TeamBareMinimunDTO.map(team);
  }

  public static List<PlayerWithTeamDTO> mapListWithTeam(List<PlayerEntity> players) {
    List<PlayerWithTeamDTO> playersDTO = new ArrayList<>();

    players.stream().forEach(p -> {
      playersDTO.add(map(p));
    });

    return playersDTO;
  }
}
