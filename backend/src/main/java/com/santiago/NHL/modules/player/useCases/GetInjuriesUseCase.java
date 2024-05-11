package com.santiago.NHL.modules.player.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.InjuryDTO;
import com.santiago.NHL.modules.player.entities.InjuryEntity;
import com.santiago.NHL.modules.player.repositories.InjuryRepository;

@Service
public class GetInjuriesUseCase {

  @Autowired
  private InjuryRepository injuryRepository;

  public List<InjuryDTO> execute() {
    List<InjuryEntity> results = injuryRepository.findAll();
    return InjuryDTO.mapList(results);
  }

}
