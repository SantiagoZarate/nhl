package com.santiago.NHL.modules.player.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillDTO {
  private int defense;
  private int pace;
  private int physique;
  private int dribble;
  private int vision;
}
