package com.santiago.NHL.modules.match.dtos;

import java.util.UUID;

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
}
