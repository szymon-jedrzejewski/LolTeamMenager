package com.team.manager.Engine;

import com.team.manager.entity.Player;
import com.team.manager.entity.PlayerStats;




public class Judge {
    Player player = new Player();



    public int laneMatchup(PlayerStats a,PlayerStats b){
        int score=0;
        for(int i=0; i<5; i++){
            if(a.getStatArray()[i]>b.getStatArray()[i]){
                score++;
            }
        }
        return score;
    }

    public String matchResult(PlayerStats AplayerStats[],PlayerStats BplayerStats[]){
        int sA=0,sB=0;
        String outcome;
        for(int i=0; i<5; i++){
            sA=sA+laneMatchup(AplayerStats[i],BplayerStats[i]);
            sB=sB+laneMatchup(BplayerStats[i],AplayerStats[i]);
        }
        System.out.println("Team A score: "+sA+" Team B score: "+sB);
        if(sA>sB){
            outcome="Team A won";
        }
        else if(sA==sB){
            outcome="Draw";
        }
        else{
            outcome="Team B won";
        }
        return outcome;
    }
}
