package com.santiago.NHL.modules.player.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePlayerDTO {
  private String name;
  private LocalDate birth_date;
  private String team;
  private String position;
  private String nationality;
  private int skill_level;
}
