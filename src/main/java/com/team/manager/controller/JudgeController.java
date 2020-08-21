package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/judge")
public class JudgeController {

    private final PlayerService playerService;

    @Autowired
    public JudgeController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/playerById/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/player/{nick}")
    public Player getPlayerByNick(@PathVariable String nick) {
        return playerService.getPlayerByNick(nick);
    }
}
