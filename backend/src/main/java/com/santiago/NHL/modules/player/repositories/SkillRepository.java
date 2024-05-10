package com.santiago.NHL.modules.player.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.NHL.modules.player.entities.SkillEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, UUID> {

}
