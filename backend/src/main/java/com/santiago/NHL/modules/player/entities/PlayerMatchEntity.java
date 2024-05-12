package com.santiago.NHL.modules.player.entities;

import com.santiago.NHL.modules.match.entities.MatchEntity;

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
@Entity(name = "player_match")
public class PlayerMatchEntity {

  @EmbeddedId
  private PlayerMatchKey id;

  @ManyToOne
  @MapsId("playerID")
  @JoinColumn(name = "player_id", referencedColumnName = "id")
  private PlayerEntity playerEntity;

  @ManyToOne
  @MapsId("matchID")
  @JoinColumn(name = "match_id", referencedColumnName = "id")
  private MatchEntity matchEntity;

  private int points;
}
