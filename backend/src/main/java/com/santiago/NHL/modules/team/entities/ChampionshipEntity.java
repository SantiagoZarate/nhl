package com.santiago.NHL.modules.team.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "championship")
public class ChampionshipEntity {

  @Id
  private String season;

  private String team_name;
}
