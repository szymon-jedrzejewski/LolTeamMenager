package com.team.manager.engine;

import com.team.manager.entity.Player;
import com.team.manager.entity.PlayerStats;

import java.util.LinkedList;
import java.util.List;

public class Match {

    PlayerStats stats = new PlayerStats();

    public int lanerComparison(Player a, Player b){
        int score=0;
        PlayerStats playerA=a.getPlayerStats(),playerB=b.getPlayerStats();
        List<Integer> playerAStats = new LinkedList<>(),playerBStats = new LinkedList<>();

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

        for(int i=0; i<5; i++){
            if(playerAStats.get(i)>playerBStats.get(i)){
                score++;
            }
        }

        return score;
    }

    public String matchSimulation(List<Player> a, List<Player> b){
        int scoreA=0,scoreB=0; String outcome;
        for(int i=0; i<5; i++){
            scoreA=scoreA+lanerComparison(a.get(i),b.get(i));
            scoreB=scoreB+lanerComparison(b.get(i),a.get(i));
        }
        System.out.println("Team A score: "+scoreA+" Team B score: "+scoreB);
        if(scoreA>scoreB){
            outcome="Team A won";
        }
        else if(scoreA==scoreB){
            outcome="Draw";
        }
        else{
            outcome="Team B won";
        }
        return outcome;
    }
}

