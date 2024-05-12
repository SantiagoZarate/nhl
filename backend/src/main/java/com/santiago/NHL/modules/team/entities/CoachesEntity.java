package com.santiago.NHL.modules.team.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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

  @ManyToOne
  @MapsId("coachID")
  @JoinColumn(name = "coach_id", referencedColumnName = "id")
  private CoachEntity coachEntity;

  @ManyToOne
  @MapsId("teamName")
  @JoinColumn(name = "team_name", referencedColumnName = "name")
  private TeamEntity teamEntity;

}
