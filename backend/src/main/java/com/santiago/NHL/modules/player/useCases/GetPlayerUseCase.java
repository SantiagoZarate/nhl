package com.santiago.NHL.modules.player.useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.dtos.TeamDTO;
import com.santiago.NHL.modules.match.entities.TeamEntity;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

@Service
public class GetPlayerUseCase {

  @Autowired
  private PlayerRepository repository;

  public List<PlayerDTO> execute() {
    List<PlayerEntity> rawPlayers = repository.findAll();
    List<PlayerDTO> playersList = new ArrayList<>();

    rawPlayers.stream().forEach(p -> {
      playersList.add(mapPlayerDTO(p));
    });

    return playersList;
  }

  public PlayerDTO byId(UUID id) throws Exception {
    Optional<PlayerEntity> player = repository.findById(id);

    return mapPlayerDTO(player.get());
  }

  private PlayerDTO mapPlayerDTO(PlayerEntity p) {
    TeamEntity team = p.getTeamEntity();
    TeamDTO teamDTO = TeamDTO
        .builder()
        .name(team.getName())
        .image_url(team.getLogo_url())
        .captain(team.getCaptain().getName())
        .build();

    PlayerDTO newPlayer = PlayerDTO
        .builder()
        .id(p.getId())
        .name(p.getName())
        .team(teamDTO)
        .build();

    return newPlayer;
  }
}
