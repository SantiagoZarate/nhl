package com.santiago.NHL.modules.match.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/match")
public class matchController {

  public String getAllMatches() {
    return "returning all the matches...";
  }
}
