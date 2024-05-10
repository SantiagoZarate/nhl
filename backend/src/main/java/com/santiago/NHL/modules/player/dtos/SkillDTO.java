package com.santiago.NHL.modules.player.dtos;

import com.santiago.NHL.modules.player.entities.SkillEntity;

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

  public static SkillDTO map(SkillEntity skill) {
    return SkillDTO
        .builder()
        .physique(skill.getDefense())
        .dribble(skill.getDribble())
        .defense(skill.getDefense())
        .vision(skill.getVision())
        .pace(skill.getPace())
        .build();
  }

}
