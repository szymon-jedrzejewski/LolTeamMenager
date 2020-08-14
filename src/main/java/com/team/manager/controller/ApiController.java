package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.repository.PlayerRepository;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final PlayerService playerService;

    @Autowired
    public ApiController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> findAllPlayers() {
        return playerService.getPlayers();
    }
}
