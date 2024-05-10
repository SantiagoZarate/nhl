package com.santiago.NHL.modules.team.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.NHL.modules.team.entities.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, String> {

}
