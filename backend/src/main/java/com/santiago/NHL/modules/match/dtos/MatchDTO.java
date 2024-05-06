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
  private String guest_team;
  private String home_team;
  private String mvp_player;
  private String winner;
  private String score;

  public static MatchDTO map(MatchEntity m) {
    return MatchDTO
        .builder()
        .id(m.getId())
        .guest_team(m.getGuest_team())
        .home_team(m.getHost_team())
        .mvp_player(m.getPlayerEntity().getName())
        .score(m.getScore())
        .winner(m.getWinner())
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
