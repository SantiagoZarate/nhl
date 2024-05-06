package com.santiago.NHL.modules.player.dtos;

import java.util.UUID;

import com.santiago.NHL.modules.match.dtos.TeamDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlayerDTO {

  private UUID id;
  private String name;
  private TeamDTO team;
}
