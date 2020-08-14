package com.team.manager.controller;

import com.team.manager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/judge")
public class JudgeController {

    private final PlayerService playerService;

    @Autowired
    public JudgeController(PlayerService playerService) {
        this.playerService = playerService;
    }
}
