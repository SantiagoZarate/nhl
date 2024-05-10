package com.santiago.NHL.modules.team.dtos;

import com.santiago.NHL.modules.team.entities.TeamEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeamBareMinimunDTO {
  private String name;
  private String city;
  private String image_url;

  public static TeamBareMinimunDTO map(TeamEntity team) {
    return TeamBareMinimunDTO
        .builder()
        .name(team.getName())
        .image_url(team.getLogo_url())
        .city(team.getCity())
        .build();
  }
}
