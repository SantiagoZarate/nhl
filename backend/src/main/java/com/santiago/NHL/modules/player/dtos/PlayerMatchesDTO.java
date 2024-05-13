package com.santiago.NHL.modules.player.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerMatchesDTO {

  private UUID id;
  private String guestTeam;
  private String hostTeam;
  private int guestTeamScore;
  private int hostTeamScore;
  private LocalDate date;
}
