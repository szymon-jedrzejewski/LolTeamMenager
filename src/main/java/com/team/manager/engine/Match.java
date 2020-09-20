package com.team.manager.engine;

import com.team.manager.entity.Player;
import com.team.manager.entity.PlayerStats;
import com.team.manager.enums.MatchResult;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Match {

    public int comparePlayerStats(Player a, Player b) {
        int score = 0;
        PlayerStats playerA = a.getPlayerStats(), playerB = b.getPlayerStats();
        List<Integer> playerAStats = new LinkedList<>(), playerBStats = new LinkedList<>();

        playerAStats.add(playerA.getLaningPhase());
        playerAStats.add(playerA.getMapAwareness());
        playerAStats.add(playerA.getMechanics());
        playerAStats.add(playerA.getPositioning());
        playerAStats.add(playerA.getTeamfighting());

        playerBStats.add(playerB.getLaningPhase());
        playerBStats.add(playerB.getMapAwareness());
        playerBStats.add(playerB.getMechanics());
        playerBStats.add(playerB.getPositioning());
        playerBStats.add(playerB.getTeamfighting());

        for (int i = 0; i < 5; i++) {
            if (playerAStats.get(i) > playerBStats.get(i)) {
                score++;
            }
        }

        return score;
    }

    public MatchResult matchResult(List<Player> teamA, List<Player> teamB) {
        int scoreA = 0, scoreB = 0;
        for (int i = 0; i < 5; i++) {
            scoreA = scoreA + comparePlayerStats(teamA.get(i), teamB.get(i));
            scoreB = scoreB + comparePlayerStats(teamB.get(i), teamA.get(i));
        }

        if (scoreA > scoreB) {
            return MatchResult.TEAM_A_WIN;
        } else if (scoreA == scoreB) {
            return MatchResult.TIE;
        } else {
            return MatchResult.TEAM_B_WIN;
        }
    }
}

