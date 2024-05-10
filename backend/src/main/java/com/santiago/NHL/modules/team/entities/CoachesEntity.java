package com.santiago.NHL.modules.team.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "coaches")
public class CoachesEntity {

  @EmbeddedId
  private CoachTeamKey id;

  private String season;
}
