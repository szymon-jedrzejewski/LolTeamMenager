package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UIController {

    private final PlayerService playerService;

    @Autowired
    public UIController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all_players")
    public String allPlayers() {
        return "all_players";
    }

    @GetMapping("/add_player")
    public String addPlayer() {
        return "add_player";
    }
}
