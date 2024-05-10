package com.santiago.NHL.modules.player.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.repositories.InjuryRepository;

@Service
public class GetInjuriesUseCase {

  @Autowired
  private InjuryRepository injuryRepository;

  // public List<InjuryDTO> execute(){
  // List<>
  // }

}
