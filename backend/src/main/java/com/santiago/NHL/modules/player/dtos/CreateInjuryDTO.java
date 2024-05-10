package com.santiago.NHL.modules.player.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateInjuryDTO {

  private String description;
  private LocalDate start;
  private LocalDate finish;
}
