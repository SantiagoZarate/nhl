package com.santiago.NHL.modules.team.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santiago.NHL.modules.player.entities.PlayerEntity;

import jakarta.persistence.CascadeType;
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

  @Id
  @Column(name = "name")
  private String name;

  @Column(length = 150)
  private String city;

  @DateTimeFormat
  private LocalDate creation;

  @Column(length = 150)
  private String logo_url;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "captain_id", referencedColumnName = "id", nullable = true)
  private PlayerEntity captain;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamEntity")
  private List<PlayerEntity> players;

  // @OneToMany(mappedBy = "hostTeam")
  // private List<GameEntity> hostMatches;

  // @OneToMany(mappedBy = "guestTeam")
  // private List<GameEntity> guestMatches;

  @OneToMany(mappedBy = "teamEntity")
  private List<CoachesEntity> coachs;
}
