package com.santiago.NHL.modules.player.entities;

import java.util.UUID;

import com.santiago.NHL.modules.match.entities.TeamEntity;

import io.micrometer.common.lang.Nullable;
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
@Entity(name = "player")
public class PlayerEntity {

  public PlayerEntity(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(length = 150)
  private String name;

  @Nullable
  @ManyToOne
  @JoinColumn(name = "team", referencedColumnName = "name")
  private TeamEntity teamEntity;
}
