package com.santiago.NHL.modules.player.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.CreateSkillsDTO;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.entities.SkillEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;
import com.santiago.NHL.modules.player.repositories.SkillRepository;

@Service
public class CreateSkillsForPlayerUseCase {

  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  private PlayerRepository playerRepository;

  public PlayerDTO execute(String playerId, CreateSkillsDTO dto) {
    Optional<PlayerEntity> player = playerRepository.findById(UUID.fromString(playerId));
    SkillEntity newSkills = SkillEntity
        .builder()
        .id(UUID.randomUUID())
        .season(dto.getSeason())
        .defense(dto.getDefense())
        .dribble(dto.getDribble())
        .physique(dto.getPhysique())
        .pace(dto.getPace())
        .vision(dto.getVision())
        .playerEntity(player.get())
        .build();

    skillRepository.save(newSkills);

    return PlayerDTO.map(player.get());
  }
}
