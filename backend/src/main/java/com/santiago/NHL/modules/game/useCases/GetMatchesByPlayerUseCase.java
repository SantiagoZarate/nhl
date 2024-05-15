package com.santiago.NHL.modules.game.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.game.entities.GameEntity;
import com.santiago.NHL.modules.game.repositories.GameRepository;
import com.santiago.NHL.modules.player.repositories.PlayerMatchRepository;

@Service
public class GetMatchesByPlayerUseCase {

  @Autowired
  private GameRepository repository;

  @Autowired
  private PlayerMatchRepository playerMatchRepository;

  public void execute(String id) {
    UUID matchID = UUID.fromString(id);
    Optional<GameEntity> matchFound = repository.findById(matchID);

    String hostTeamName = matchFound.get().getLocal().getName();
    String guestTeamName = matchFound.get().getAway().getName();

    System.out.println(matchID);
    System.out.println(hostTeamName);
    System.out.println(guestTeamName);
    List<Integer> playersID = playerMatchRepository.findPlayersByTeamAndMatchID(matchID, hostTeamName);
    System.out.println(playersID);
    // List<PlayerMatchEntity> hostPlayers =
    // playerMatchRepository.findPlayersByTeamAndMatchID(matchID, hostTeamName);
    // List<PlayerMatchEntity> guestPlayers =
    // playerMatchRepository.findPlayersByTeamAndMatchID(matchID, guestTeamName);

    // System.out.println(hostPlayers);
    // System.out.println(guestPlayers);
    // return hostPlayers;
  }

}
