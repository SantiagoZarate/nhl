package com.santiago.NHL.modules.player.entities;

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
public class PlayerMatchKey implements Serializable {

  @Column(name = "match_id")
  private UUID matchID;

  @Column(name = "player_id")
  private UUID playerID;
}
