package com.santiago.NHL.modules.player.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.game.dtos.TeamDTO;
import com.santiago.NHL.modules.player.entities.InjuryEntity;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.entities.SkillEntity;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerDTO {

  private UUID id;
  private String name;

  private String nationality;
  private String position;
  private int skill_level;
  private SkillDTO skills;
  private List<InjuryDTO> injuries;

  public static PlayerDTO map(PlayerEntity p) {

    PlayerDTO newPlayer = PlayerDTO
        .builder()
        .id(p.getId())
        .name(p.getName())
        .nationality(p.getNationality())
        .skill_level(p.getSkill_level())
        .position(p.getPosition())
        .skills(extractSkill(p.getSkills()))
        .injuries(extractInjuries(p.getInjurys()))
        .build();

    return newPlayer;
  }

  public static SkillDTO extractSkill(List<SkillEntity> skills) {
    if (skills.isEmpty()) {
      return null;
    }

    SkillEntity lastSeasonSkill = skills.get(0);
    return SkillDTO.map(lastSeasonSkill);
  }

  public static List<InjuryDTO> extractInjuries(List<InjuryEntity> rawInjuries) {
    if (rawInjuries.isEmpty()) {
      return null;
    }
    return InjuryDTO.mapList(rawInjuries);
  }

  public static TeamDTO extractTeam(TeamEntity team) {
    if (team == null) {
      return null;
    }

    boolean hasCaptain = team.getCaptain() != null;
    TeamDTO teamDTO = TeamDTO
        .builder()
        .name(team.getName())
        .image_url(team.getLogo_url())
        .captain(hasCaptain ? team.getCaptain().getName() : "")
        .build();

    return teamDTO;
  }

  public static List<PlayerDTO> mapList(List<PlayerEntity> players) {
    List<PlayerDTO> playersDTO = new ArrayList<>();

    players.stream().forEach(p -> {
      playersDTO.add(map(p));
    });

    return playersDTO;
  }
}
