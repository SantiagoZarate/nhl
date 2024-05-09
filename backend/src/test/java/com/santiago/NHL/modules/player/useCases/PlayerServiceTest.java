package com.santiago.NHL.modules.player.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.santiago.NHL.modules.match.entities.TeamEntity;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.entities.PlayerEntity;
import com.santiago.NHL.modules.player.repositories.PlayerRepository;

// @SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

  // @Autowired
  @InjectMocks
  private GetPlayerUseCase useCase;

  // @MockBean
  @Mock
  private PlayerRepository repository;

  @BeforeEach
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void getPlayerById() throws Exception {
    UUID id = new UUID(0, 0);
    TeamEntity team = TeamEntity.builder().name("New Jersey").captain(new PlayerEntity()).build();
    Optional<PlayerEntity> newPlayer = Optional.of(PlayerEntity
        .builder()
        .id(id)
        .name("Santiago")
        .teamEntity(team)
        .build());

    when(repository.findById(id)).thenReturn(newPlayer);

    PlayerDTO foundPlayer = useCase.byId(id);
    assertNotNull(foundPlayer);
    assertEquals(foundPlayer.getId(), id);
    assertEquals(foundPlayer.getName(), "Santiago");
  }
}
