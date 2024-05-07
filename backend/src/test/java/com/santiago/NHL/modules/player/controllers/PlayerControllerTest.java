package com.santiago.NHL.modules.player.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.santiago.NHL.modules.player.dtos.PlayerDTO;
import com.santiago.NHL.modules.player.useCases.GetPlayerUseCase;

@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetPlayerUseCase service;

  @Test
  public void getPlayerById() throws Exception {
    UUID id = new UUID(0, 0);
    PlayerDTO newPlayer = PlayerDTO.builder().id(id).name("Santiago").build();

    Mockito.when(service.byId(id)).thenReturn(newPlayer);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/v1/players/" + id.toString()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id.toString())))
        .andDo(MockMvcResultHandlers.print()); /* Print for debug */
  }

  @Test
  public void getAllPlayersTest() throws Exception {
    PlayerDTO p1 = PlayerDTO.builder().id(new UUID(0, 0)).name("Santiago").build();
    PlayerDTO p2 = PlayerDTO.builder().id(new UUID(0, 0)).name("Nicolas").build();

    List<PlayerDTO> players = new ArrayList<>();

    players.add(p1);
    players.add(p2);

    Mockito.when(service.execute()).thenReturn(players);

    mockMvc
        .perform(MockMvcRequestBuilders.get("/api/v1/players"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
  }

  @Test
  public void getPlayersByNameTest() throws Exception {
    throw new Exception("Not yet implemented");
  }

  @Test
  public void getPlayersByTeamTest() throws Exception {
    throw new Exception("Not yet implemented");
  }

  @Test
  public void getPlayersLimitTest() throws Exception {
    throw new Exception("Not yet implemented");
  }
}
