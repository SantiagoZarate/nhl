package com.santiago.NHL.modules.team.entities;

import java.util.UUID;

import com.santiago.NHL.modules.game.entities.GameEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "team_stats")
public class TeamStatsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "team_name")
  private TeamEntity teamEntity;

  @ManyToOne
  @JoinColumn(name = "game_id")
  private GameEntity gameEntity;

  private int points;
}
