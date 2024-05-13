package com.santiago.NHL.modules.match.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;
import com.santiago.NHL.modules.player.entities.PlayerMatchEntity;
import com.santiago.NHL.modules.player.repositories.PlayerMatchRepository;

@Service
public class GetMatchesByPlayerUseCase {

  @Autowired
  private MatchRepository repository;

  @Autowired
  private PlayerMatchRepository playerMatchRepository;

  public void execute(String id) {
    UUID matchID = UUID.fromString(id);
    Optional<MatchEntity> matchFound = repository.findById(matchID);

    String hostTeamName = matchFound.get().getHostTeam().getName();
    String guestTeamName = matchFound.get().getGuestTeam().getName();

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
