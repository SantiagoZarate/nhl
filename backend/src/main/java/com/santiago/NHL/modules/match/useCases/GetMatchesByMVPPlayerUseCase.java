package com.santiago.NHL.modules.match.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;

@Service
public class GetMatchesByMVPPlayerUseCase {

  @Autowired
  private MatchRepository repository;

  public List<MatchDTO> execute(String mvp) {
    List<MatchEntity> matchs = repository.findAllMvpMatches(mvp);
    return MatchDTO.mapList(matchs);
  };
}
