package com.santiago.NHL.modules.player.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santiago.NHL.modules.player.entities.PlayerEntity;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, UUID> {

  @Query(value = "SELECT * FROM player LIMIT :limit OFFSET :skip", nativeQuery = true)
  public List<PlayerEntity> findAll(int limit, int skip);

  @Query(value = "SELECT * FROM player WHERE name LIKE %:name%", nativeQuery = true)
  public List<PlayerEntity> findByName(String name);

  @Query(value = "SELECT * FROM player WHERE team_name = :team", nativeQuery = true)
  public List<PlayerEntity> findByTeam(String team);
}
