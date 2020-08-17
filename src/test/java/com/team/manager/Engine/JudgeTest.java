package com.team.manager.Engine;

import com.team.manager.entity.PlayerStats;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    Judge judge = new Judge();
    PlayerStats p1 = new PlayerStats(1,1,1,1,1),
                p2 = new PlayerStats(1,1,1,1,1),
                p3 = new PlayerStats(3,3,3,3,3),
                p4 = new PlayerStats(1,1,1,1,1),
                p5 = new PlayerStats(1,1,1,1,1),
                p6 = new PlayerStats(1,1,1,1,1),
                p7 = new PlayerStats(1,1,1,1,1),
                p8 = new PlayerStats(1,1,1,1,1),
                p9 = new PlayerStats(1,1,1,1,1),
                p10 = new PlayerStats(1,1,1,1,1);
    PlayerStats[] teamA={p1,p2,p3,p4,p5},teamB={p6,p7,p8,p9,p10};
    public void print() {
        System.out.println(Arrays.toString(p3.getStatArray()));
        System.out.println(Arrays.toString(p2.getStatArray()));
    }

    @Test
    public void shouldNotReturnZero(){
        print();
        assertNotEquals(0,judge.laneMatchup(p3,p2));
    }
    @Test
    public void shouldReturnExpectedOutcome(){
        String result=judge.matchResult(teamA,teamB);
        assertTrue(result.equals("Team A won")||result.equals("Draw")||result.equals("Team B won"));
        System.out.println(result);
    }

}

