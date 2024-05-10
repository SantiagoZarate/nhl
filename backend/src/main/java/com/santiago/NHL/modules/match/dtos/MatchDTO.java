package com.santiago.NHL.modules.match.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.match.entities.MatchEntity;

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

  public static MatchDTO map(MatchEntity m) {
    return MatchDTO
        .builder()
        .id(m.getId())
        .guest_team(m.getGuest_team())
        .host_team(m.getHost_team())
        .mvp_player(m.getPlayerEntity().getName())
        .guest_team_score(m.getGuest_team_score())
        .host_team_score(m.getHost_team_score())
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
