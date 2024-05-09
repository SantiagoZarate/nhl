package com.santiago.NHL.modules.match.entities;

import java.util.ArrayList;
import java.util.List;

import com.santiago.NHL.modules.match.dtos.TeamDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "team")
public class TeamEntity {

  public TeamEntity(String name) {
    this.name = name;
  }

  @Id
  @Column(name = "name")
  private String name;

  @Column(length = 150)
  private String logo_url;

  @OneToOne
  @JoinColumn(name = "captain_id", referencedColumnName = "id")
  @Nullable
  private PlayerEntity captain;

  @OneToMany(mappedBy = "teamEntity")
  private List<PlayerEntity> players;

  public static TeamDTO map(TeamEntity rawTeam) {
    TeamDTO mappedTeam = new TeamDTO(rawTeam.getName(), rawTeam.getLogo_url(), rawTeam.getCaptain().getName());
    return mappedTeam;
  }

  public static List<TeamDTO> mapList(List<TeamEntity> rawTeams) {
    List<TeamDTO> teams = new ArrayList<>();

    rawTeams.stream().forEach(t -> {
      teams.add(map(t));
    });

    return teams;
  }
}
