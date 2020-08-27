package com.team.manager.service;

import com.team.manager.entity.Player;
import com.team.manager.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player getPlayerByNick(String nick) {
        return playerRepository.findByNick(nick).orElse(null);
    }

    public String deletePlayerById(int id) {
        playerRepository.deleteById(id);
        return "Player with id " + id + " was deleted!";
    }

    public String deletePlayer(String nick) {
        Player playerToDelete = playerRepository.findByNick(nick).orElse(null);
        playerRepository.deleteById(playerToDelete.getId());
        return "Player with nick " + nick + " was deleted!";
    }

    public Player updatePlayer(Player player) {

        Player actualPlayer = playerRepository.findById(player.getId()).orElse(null);

        actualPlayer.setName(player.getName());
        actualPlayer.setSurname(player.getSurname());
        actualPlayer.setNick(player.getNick());
        actualPlayer.setRole(player.getRole());
        actualPlayer.setAge(player.getAge());
        actualPlayer.setPlayerStats(player.getPlayerStats());
        actualPlayer.setTeam(player.getTeam());

        return playerRepository.save(player);
    }
}
