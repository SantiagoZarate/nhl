package com.santiago.NHL.modules.match.useCases;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.NHL.modules.match.dtos.MatchDTO;
import com.santiago.NHL.modules.match.entities.MatchEntity;
import com.santiago.NHL.modules.match.repositories.MatchRepository;

@Service
public class GetMatchesUseCase {

  @Autowired
  MatchRepository repository;

  public List<MatchDTO> execute() {
    List<MatchEntity> rawMatchs = repository.findAll();
    return MatchDTO.mapList(rawMatchs);
  }

  public List<MatchEntity> latests() {
    return repository.findAllMatchesSortedByDate();
  }

  public MatchDTO byId(String id) {
    Optional<MatchEntity> matchFound = repository.findById(UUID.fromString(id));
    return MatchDTO.map(matchFound.get());
  }
}
