package com.santiago.NHL.modules.player.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.player.dtos.CreatePlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;
import com.santiago.NHL.modules.team.entities.TeamEntity;
import com.santiago.NHL.modules.team.repositories.TeamRepository;

@Service
public class CreatePlayerUseCase {

  @Autowired
  private PlayerRepository playerRepository;

  @Autowired
  private TeamRepository teamRepository;

  public PlayerEntity execute(CreatePlayerDTO dto) {
    Optional<TeamEntity> team = teamRepository.findById(dto.getTeam());

    PlayerEntity newPlayer = PlayerEntity
        .builder()
        .id(UUID.randomUUID())
        .name(dto.getName())
        .nationality(dto.getNationality())
        .birth_date(dto.getBirth_date())
        .position(dto.getPosition())
        .skill_level(dto.getSkill_level())
        .teamEntity(team.get())
        .build();

    PlayerEntity result = playerRepository.save(newPlayer);
    return result;
  }
}
