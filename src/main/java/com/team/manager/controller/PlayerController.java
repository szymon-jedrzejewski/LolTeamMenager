package com.team.manager.controller;

import com.team.manager.entity.Player;
import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<String> addPlayer(@Valid @RequestBody Player player) {
        playerService.addPlayer(player);
        return ResponseEntity.ok("User was added.");
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationsExceptions(MethodArgumentNotValidException exception) {
        Map <String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
