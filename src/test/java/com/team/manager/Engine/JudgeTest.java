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
                p2 = new PlayerStats(200,200,200,200,200);
    public void print() {
        System.out.println(Arrays.toString(p1.getStatArray()));
        System.out.println(Arrays.toString(p2.getStatArray()));
    }

    @Test
    public void shouldNotReturnZero(){
        print();
        assertNotEquals(0,judge.laneMatchup(p2,p1));
    }

}

