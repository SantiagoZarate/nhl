package com.santiago.NHL.modules.match.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.santiago.NHL.modules.player.entities.PlayerEntity;

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
@Entity(name = "match")
public class MatchEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String host_team;

  private String guest_team;

  @ManyToOne
  @JoinColumn(name = "mvp_player_id")
  private PlayerEntity playerEntity;

  private String score;

  @Column(nullable = true)
  private String winner;

  @Column(columnDefinition = "DATE")
  private LocalDate date;

}
