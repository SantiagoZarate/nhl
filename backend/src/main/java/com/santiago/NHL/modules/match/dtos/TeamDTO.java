package com.santiago.NHL.modules.match.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

  private String name;
  private String image_url;
  private String captain;

}
