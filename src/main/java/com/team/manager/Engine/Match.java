package com.team.manager.Engine;

import com.team.manager.entity.Player;
import com.team.manager.entity.PlayerStats;

public class Match {

    PlayerStats stats = new PlayerStats();

    public int lanerComparison(PlayerStats a, PlayerStats b){
        int score=0;
        if(a.getPositioning()>b.getPositioning()){
            score++;
        }
        if(a.getTeamfighting()>b.getTeamfighting()){
            score++;
        }
        if(a.getLaningPhase()>b.getLaningPhase()){
            score++;
        }
        if(a.getMapAwareness()>b.getMapAwareness()){
            score++;
        }
        if(a.getMechanics()>b.getMechanics()){
            score++;
        }

        return score;
    }

    public void matchSimulation(PlayerStats a[], PlayerStats b[]){
        int scoreA=0,scoreB=0; String outcome;
        for(int i=0; i<5; i++){
            scoreA=scoreA+lanerComparison(a[i],b[i]);
            scoreB=scoreB+lanerComparison(b[i],a[i]);
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
        System.out.println(outcome);
    }
}

