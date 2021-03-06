package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player_api")
@CrossOrigin(methods = {RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT})
public class PlayerController
{

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
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

    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }
}
