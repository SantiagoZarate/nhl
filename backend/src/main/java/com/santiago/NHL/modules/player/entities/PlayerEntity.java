package com.santiago.NHL.modules.player.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.team.entities.TeamEntity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
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
@Entity(name = "player")
public class PlayerEntity {

  public PlayerEntity(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private UUID id;

  @Column(length = 150)
  private String name;

  @Column(length = 5)
  private int skill_level;

  @DateTimeFormat
  private LocalDate birth_date;

  private String position;

  private String nationality;

  @JsonIgnore
  @Nullable
  @ManyToOne
  @JoinColumn(name = "team_name", referencedColumnName = "name")
  private TeamEntity teamEntity;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerEntity")
  private List<SkillEntity> skills;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerEntity")
  private List<InjuryEntity> injurys;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerEntity")
  private List<MatchEntity> mvps;

  @OneToMany(mappedBy = "playerEntity")
  private List<PlayerMatchEntity> matches;

}
