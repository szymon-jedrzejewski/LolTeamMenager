package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FirstController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/first_view")
    public String hello() {
        return "index";
    }

    @GetMapping("/players")
    public List<Player> findAllPlayers() {
        return playerService.getPlayers();
    }
}
