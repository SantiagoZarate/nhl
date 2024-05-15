package com.santiago.NHL.modules.player.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santiago.NHL.modules.player.entities.PlayerStatsEntity;

@Repository
public interface PlayerStatsRepository extends JpaRepository<PlayerStatsEntity, UUID> {

  @Query(value = "SELECT * FROM player_stats WHERE player_id = :playerID", nativeQuery = true)
  List<PlayerStatsEntity> findByPlayer(UUID playerID);

  @Query(value = "SELECT * FROM player_stats WHERE game_id = :gameID", nativeQuery = true)
  List<PlayerStatsEntity> findByGame(UUID gameID);
}
