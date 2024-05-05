package com.santiago.NHL.modules.match.entities;

import java.util.List;

import com.santiago.NHL.modules.player.entities.PlayerEntity;

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
  private String logo_url;

  @OneToOne
  @JoinColumn(name = "captain_id", referencedColumnName = "id")
  private PlayerEntity captain;

  @OneToMany(mappedBy = "teamEntity")
  private List<PlayerEntity> players;
}
