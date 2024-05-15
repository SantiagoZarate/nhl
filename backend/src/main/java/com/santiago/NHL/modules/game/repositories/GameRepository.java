package com.santiago.NHL.modules.game.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.game.entities.GameEntity;

@Service
public interface GameRepository extends JpaRepository<GameEntity, UUID> {

  @Query(value = "SELECT m.*, pm.points FROM player_match AS pm, game AS m WHERE pm.player_id = :playerID AND pm.match_id = m.id;", nativeQuery = true)
  List<?> findAllByPlayer(UUID playerID);

  @Query(value = "SELECT * FROM game m WHERE LOWER(m.winner) = :team", nativeQuery = true)
  List<GameEntity> findAllMatchesWonByTeam(String team);

  @Query(value = "SELECT * FROM game m ORDER BY m.date DESC", nativeQuery = true)
  List<GameEntity> findAllMatchesSortedByDate();

  @Query(value = "SELECT * FROM game m ORDER BY m.date DESC LIMIT :amount", nativeQuery = true)
  List<GameEntity> findLatestMatches(String amount);

  @Query(value = "SELECT * FROM game m WHERE LOWER(m.guest_team) = :team OR LOWER(m.host_team) = :team LIMIT :amount", nativeQuery = true)
  List<GameEntity> findAllByTeam(String team, int amount);

  @Query(value = "SELECT * FROM game m WHERE m.mvp_player_id = :mvp", nativeQuery = true)
  public List<GameEntity> findAllMvpMatches(String mvp);
}
