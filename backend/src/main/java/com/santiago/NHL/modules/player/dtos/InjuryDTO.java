package com.santiago.NHL.modules.player.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.santiago.NHL.modules.player.entities.InjuryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InjuryDTO {

  private String description;
  private LocalDate start;
  private LocalDate finish;

  public static InjuryDTO map(InjuryEntity injury) {
    return InjuryDTO
        .builder()
        .description(injury.getDescription())
        .start(injury.getStart())
        .finish(injury.getFinish())
        .build();
  }

  public static List<InjuryDTO> mapList(List<InjuryEntity> rawInjuries) {
    List<InjuryDTO> injuries = new ArrayList<>();

    rawInjuries.stream().forEach(inj -> {
      injuries.add(map(inj));
    });

    return injuries;
  }
}
