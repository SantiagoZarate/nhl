package com.santiago.NHL.modules.player.entities;

import java.util.UUID;

import com.santiago.NHL.modules.game.entities.GameEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "player_stats")
public class PlayerStatsEntity {

  @Id
  @GeneratedValue()
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "player_id", referencedColumnName = "id")
  private PlayerEntity playerEntity;

  @ManyToOne
  @JoinColumn(name = "game_id", referencedColumnName = "id")
  private GameEntity gameEntity;

  private int points;
  private int minutes_played;
}