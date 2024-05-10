package com.santiago.NHL.modules.match.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

  private String name;
  private String image_url;
  private String city;
  private String captain;
  private LocalDate creation;
  private List<PlayerDTO> players;

  public static TeamDTO map(TeamEntity rawTeam) {
    TeamDTO team = TeamDTO
        .builder()
        .name(rawTeam.getName())
        .image_url(rawTeam.getLogo_url())
        .creation(rawTeam.getCreation())
        .captain(extractCaptainName(rawTeam.getCaptain()))
        .city(rawTeam.getCity())
        .players(extractPlayers(rawTeam.getPlayers()))
        .build();

    return team;
  }

  public static List<TeamDTO> mapList(List<TeamEntity> rawTeams) {
    List<TeamDTO> teams = new ArrayList<>();

    rawTeams.stream().forEach(t -> {
      teams.add(map(t));
    });

    return teams;
  }

  public static String extractCaptainName(PlayerEntity teamCaptain) {
    if (teamCaptain == null) {
      return null;
    }

    return teamCaptain.getName();
  }

  public static List<PlayerDTO> extractPlayers(List<PlayerEntity> rawPlayers) {
    if (rawPlayers.isEmpty()) {
      return null;
    }

    return PlayerDTO.mapList(rawPlayers);
  }
}
