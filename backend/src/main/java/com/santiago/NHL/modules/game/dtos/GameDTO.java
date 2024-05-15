package com.santiago.NHL.modules.game.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.game.entities.GameEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

  private UUID id;
  private String mvp_player;
  private String local;
  private String away;
  private int local_score;
  private int away_score;

  // private List<PlayerMatchEntity> host_team_players;
  // private List<PlayerMatchEntity> guest_team_players;

  public static GameDTO map(GameEntity m) {
    return GameDTO
        .builder()
        .id(m.getId())
        .away(m.getAway().getName())
        .local(m.getLocal().getName())
        .mvp_player(m.getPlayerEntity().getName())
        .away_score(m.getAway_score())
        .local_score(m.getLocal_score())
        // .host_team_players(m.getHost_team_players())
        // .guest_team_players(m.getGuest_team_players())
        .build();
  }

  public static List<GameDTO> mapList(List<GameEntity> lm) {
    List<GameDTO> matches = new ArrayList<>();

    lm.forEach(m -> {
      matches.add(map(m));
    });

    return matches;
  }
}
