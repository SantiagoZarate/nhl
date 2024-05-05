package com.santiago.NHL.modules.match.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.entities.MatchEntity;

@Service
public interface MatchRepository extends JpaRepository<MatchEntity, UUID> {

  @Query(value = "SELECT * FROM match m WHERE m.winner = :team", nativeQuery = true)
  List<MatchEntity> findAllMatchesWonByTeam(String team);

  @Query(value = "SELECT * FROM match m ORDER BY m.date DESC", nativeQuery = true)
  List<MatchEntity> findAllMatchesSortedByDate();
}
