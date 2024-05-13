package com.santiago.NHL.modules.match.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.player.entities.PlayerMatchEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {

  private UUID id;
  private String mvp_player;
  private String host_team;
  private String guest_team;
  private int host_team_score;
  private int guest_team_score;

  private List<PlayerMatchEntity> host_team_players;
  private List<PlayerMatchEntity> guest_team_players;

  public static MatchDTO map(MatchEntity m) {
    return MatchDTO
        .builder()
        .id(m.getId())
        .guest_team(m.getGuestTeam().getName())
        .host_team(m.getHostTeam().getName())
        .mvp_player(m.getPlayerEntity().getName())
        .guest_team_score(m.getGuest_team_score())
        .host_team_score(m.getHost_team_score())
        .host_team_players(m.getHost_team_players())
        .guest_team_players(m.getGuest_team_players())
        .build();
  }

  public static List<MatchDTO> mapList(List<MatchEntity> lm) {
    List<MatchDTO> matches = new ArrayList<>();

    lm.forEach(m -> {
      matches.add(map(m));
    });

    return matches;
  }
}
