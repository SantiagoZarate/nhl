package com.santiago.NHL.modules.team.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.NHL.modules.match.entities.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, String> {

}
