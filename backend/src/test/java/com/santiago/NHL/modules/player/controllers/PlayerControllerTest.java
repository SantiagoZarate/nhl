package com.santiago.NHL.modules.player.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.santiago.NHL.modules.match.dtos.TeamDTO;
import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.useCases.CreatePlayerUseCase;
import com.santiago.NHL.modules.player.useCases.GetPlayerUseCase;

@WebMvcTest(controllers = PlayerController.class)
public class PlayerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetPlayerUseCase getPlayers;

  @MockBean
  private CreatePlayerUseCase createPlayer;

  @Test
  public void getPlayerById() throws Exception {
    UUID id = new UUID(0, 0);
    PlayerDTO newPlayer = PlayerDTO.builder().id(id).name("Santiago").build();

    Mockito.when(getPlayers.byId(id)).thenReturn(newPlayer);

    mockMvc
        .perform(get("/api/v1/players/" + id.toString()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", is(id.toString())));
  }

  @Test
  public void getAllPlayersTest() throws Exception {
    PlayerDTO p1 = PlayerDTO.builder().id(new UUID(0, 0)).name("Santiago").build();
    PlayerDTO p2 = PlayerDTO.builder().id(new UUID(0, 0)).name("Nicolas").build();

    List<PlayerDTO> players = new ArrayList<>();

    players.add(p1);
    players.add(p2);

    Mockito.when(getPlayers.execute(10, 0)).thenReturn(players);

    mockMvc
        .perform(get("/api/v1/players"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.results", hasSize(2)));
  }

  @Test
  public void getPlayersByNameTest() throws Exception {
    List<PlayerDTO> players = new ArrayList<>();

    PlayerDTO p1 = new PlayerDTO(UUID.randomUUID(), "Marcos", new TeamDTO("Philadelphia", "", ""));
    PlayerDTO p2 = new PlayerDTO(UUID.randomUUID(), "Mario", new TeamDTO("Philadelphia", "", ""));

    players.add(p1);
    players.add(p2);

    when(getPlayers.byName("marc")).thenReturn(players);

    mockMvc
        .perform(get("/api/v1/players/name/marc"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", isA(ArrayList.class)))
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Disabled
  @Test
  public void getPlayersByTeamTest() throws Exception {
    throw new Exception("Not yet implemented");
  }

  @Test
  public void getPlayersLimitTest() throws Exception {
    List<PlayerDTO> players = generateRandomPlayersList(3);

    when(getPlayers.execute(3, 0)).thenReturn(players);

    mockMvc
        .perform(get("/api/v1/players?limit=3"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.skip", equalTo("0")))
        .andExpect(jsonPath("$.limit", equalTo("3")))
        .andExpect(jsonPath("$.results", hasSize(3)));
  }

  @Test
  public void createNewPlayer() throws Exception {
    // when(service.execute(12, 12)).thenReturn(42L);

    mockMvc.perform(post("/api/v1/players")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
              "name" : "Juan",
            }
            """)//
    ).andExpect(status().isCreated());

    verify(createPlayer).execute("Juan");
  }

  public List<PlayerDTO> generateRandomPlayersList(int amount) {
    List<PlayerDTO> players = new ArrayList<>();

    for (int i = 0; i < amount; i++)
      players.add(generateRandomPlayer());

    return players;
  }

  public PlayerDTO generateRandomPlayer() {
    Double n = new Random().nextDouble();
    String team;

    if (n < 0.4) {
      team = "Buffalo";
    } else if (n < 0.7) {
      team = "Philadelphia";
    } else {
      team = "New Jersey";
    }

    return new PlayerDTO(UUID.randomUUID(), n.toString(), new TeamDTO(team, "", ""));
  }
}
