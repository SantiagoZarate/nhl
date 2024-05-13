package com.santiago.NHL.modules.match.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.entities.MatchEntity;

@Service
public interface MatchRepository extends JpaRepository<MatchEntity, UUID> {

  @Query(value = "SELECT m.*, pm.points FROM player_match AS pm, match AS m WHERE pm.player_id = :playerID AND pm.match_id = m.id;", nativeQuery = true)
  List<?> findAllByPlayer(UUID playerID);

  @Query(value = "SELECT * FROM match m WHERE LOWER(m.winner) = :team", nativeQuery = true)
  List<MatchEntity> findAllMatchesWonByTeam(String team);

  @Query(value = "SELECT * FROM match m ORDER BY m.date DESC", nativeQuery = true)
  List<MatchEntity> findAllMatchesSortedByDate();

  @Query(value = "SELECT * FROM match m ORDER BY m.date DESC LIMIT :amount", nativeQuery = true)
  List<MatchEntity> findLatestMatches(String amount);

  @Query(value = "SELECT * FROM match m WHERE LOWER(m.guest_team) = :team OR LOWER(m.host_team) = :team LIMIT :amount", nativeQuery = true)
  List<MatchEntity> findAllByTeam(String team, int amount);

  @Query(value = "SELECT * FROM match m WHERE m.mvp_player_id = :mvp", nativeQuery = true)
  public List<MatchEntity> findAllMvpMatches(String mvp);
}
