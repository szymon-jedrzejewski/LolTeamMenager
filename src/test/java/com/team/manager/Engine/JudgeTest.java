package com.team.manager.Engine;

import com.team.manager.entity.PlayerStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    Judge judge = new Judge();
    PlayerStats p1 = new PlayerStats(100,100,100,100,100),
                p2 = new PlayerStats(200,200,200,200,200),
                p3 = new PlayerStats(300,300,300,300,300),
                p4 = new PlayerStats(200,200,200,200,200),
                p5 = new PlayerStats(500,500,500,500,500),
                p6 = new PlayerStats(200,200,200,200,200),
                p7 = new PlayerStats(400,400,400,400,400),
                p8 = new PlayerStats(200,200,200,200,200),
                p9 = new PlayerStats(200,200,200,200,200),
                p10 = new PlayerStats(200,200,200,200,200);
    PlayerStats[] teamA={p1,p2,p3,p4,p5},teamB={p6,p7,p8,p9,p10};
    public void print() {
        System.out.println(Arrays.toString(p1.getStatArray()));
        System.out.println(Arrays.toString(p2.getStatArray()));
    }

    @Test
    public void shouldNotReturnZero(){
        print();
        assertNotEquals(0,judge.laneMatchup(p2,p1));
    }
    @Test
    public void shouldReturnExpectedOutcome(){
        String result=judge.matchResult(teamA,teamB);
        assertTrue(result.equals("Team A won")||result.equals("Draw")||result.equals("Team B won"));
    }

}

