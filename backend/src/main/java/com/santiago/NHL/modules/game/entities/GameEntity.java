package com.santiago.NHL.modules.game.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "game")
public class GameEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "local", referencedColumnName = "name")
  private TeamEntity local;

  @ManyToOne
  @JoinColumn(name = "away", referencedColumnName = "name")
  private TeamEntity away;

  @ManyToOne
  @JoinColumn(name = "mvp_player_id", referencedColumnName = "id")
  private PlayerEntity playerEntity;

  @Column(columnDefinition = "DATE")
  private LocalDate date;

  private int local_score;

  private int away_score;

  // @OneToMany(mappedBy = "matchEntity")
  // private List<PlayerMatchEntity> host_team_players;

  // @OneToMany(mappedBy = "matchEntity")
  // private List<PlayerMatchEntity> guest_team_players;

}
