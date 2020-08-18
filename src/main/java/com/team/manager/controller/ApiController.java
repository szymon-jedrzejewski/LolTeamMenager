package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/playerById/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("/player/{nick}")
    public Player getPlayerByNick(@PathVariable String nick) {
        return playerService.getPlayerByNick(nick);
    }

    @PostMapping("/add")
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deletePlayerById(@PathVariable int id) {
        return playerService.deletePlayerById(id);
    }

    @DeleteMapping("delete/{nick}")
    public String deletePlayer(@PathVariable String nick) {
        return playerService.deletePlayer(nick);
    }
}
