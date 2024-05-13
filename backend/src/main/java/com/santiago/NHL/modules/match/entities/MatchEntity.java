package com.santiago.NHL.modules.match.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.entities.PlayerMatchEntity;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "match")
public class MatchEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "host_team_name", referencedColumnName = "name")
  private TeamEntity hostTeam;

  @ManyToOne
  @JoinColumn(name = "guest_team_name", referencedColumnName = "name")
  private TeamEntity guestTeam;

  private int host_team_score;

  private int guest_team_score;

  @Column(columnDefinition = "DATE")
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "mvp_player_id", referencedColumnName = "id")
  private PlayerEntity playerEntity;

  @OneToMany(mappedBy = "matchEntity")
  private List<PlayerMatchEntity> host_team_players;

  @OneToMany(mappedBy = "matchEntity")
  private List<PlayerMatchEntity> guest_team_players;

}
