package com.santiago.NHL.modules.team.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class CoachTeamKey implements Serializable {

  @Column(name = "coach_id")
  private UUID coachID;

  @Column(name = "team_name")
  private String teamName;

  @Column(name = "season")
  private String season;
}