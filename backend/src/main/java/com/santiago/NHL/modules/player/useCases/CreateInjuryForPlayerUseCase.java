package com.santiago.NHL.modules.player.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.CreateInjuryDTO;
import com.santiago.NHL.modules.player.dtos.InjuryDTO;
import com.santiago.NHL.modules.player.entities.InjuryEntity;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.InjuryRepository;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

@Service
public class CreateInjuryForPlayerUseCase {

  @Autowired
  private InjuryRepository injuryRepository;

  @Autowired
  private PlayerRepository playerRepository;

  public InjuryDTO execute(String playerId, CreateInjuryDTO dto) {
    Optional<PlayerEntity> foundPlayer = playerRepository.findById(UUID.fromString(playerId));
    InjuryEntity newInjury = InjuryEntity
        .builder()
        .description(dto.getDescription())
        .start(dto.getStart())
        .finish(dto.getFinish())
        .playerEntity(foundPlayer.get())
        .build();

    InjuryEntity savedEntity = injuryRepository.save(newInjury);
    return InjuryDTO.map(savedEntity);
  }
}
