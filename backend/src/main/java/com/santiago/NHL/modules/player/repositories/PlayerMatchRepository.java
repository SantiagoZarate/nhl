package com.santiago.NHL.modules.player.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santiago.NHL.modules.player.entities.PlayerMatchEntity;
import com.santiago.NHL.modules.player.entities.PlayerMatchKey;

@Repository
public interface PlayerMatchRepository extends JpaRepository<PlayerMatchEntity, PlayerMatchKey> {

  @Query(value = """
      SELECT pm.points
      FROM player_match pm, player p
      WHERE pm.match_id = :matchID
      AND pm.player_id = p.id
      AND p.team_name = :teamName ;
      """, nativeQuery = true)
  public List<Integer> findPlayersByTeamAndMatchID(
      @Param("matchID") UUID matchID,
      @Param("teamName") String teamName);
}
