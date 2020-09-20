package com.team.manager.engine;

import com.team.manager.entity.Player;
import com.team.manager.entity.PlayerStats;
import com.team.manager.enums.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {
    Match match;

    @BeforeEach
    void setUp() {
        match = new Match();
    }

    @Test
    void shouldEqualInteger() {
        Player player1 = new Player(), player2 = new Player();
        PlayerStats statsP1 = new PlayerStats(), statsP2 = new PlayerStats();
        statsP1.setTeamfighting(101);
        statsP1.setPositioning(101);
        player1.setPlayerStats(statsP1);
        player2.setPlayerStats(statsP2);
        System.out.println(player1.toString());
        System.out.println(player2.toString());
        System.out.println(match.comparePlayerStats(player1, player2));
        assertEquals(2, match.comparePlayerStats(player1, player2));
    }

    @Test
    void shouldReturnDraw() {
        Player pA1 = new Player(), pA2 = new Player(), pA3 = new Player(), pA4 = new Player(), pA5 = new Player(),
                pB1 = new Player(), pB2 = new Player(), pB3 = new Player(), pB4 = new Player(), pB5 = new Player();

        PlayerStats statsBetter = new PlayerStats(), statsWorse = new PlayerStats();

        statsBetter.setMechanics(200);
        statsBetter.setPositioning(200);


        List<Player> TeamA = new LinkedList<>(), TeamB = new LinkedList<>();

        pA1.setPlayerStats(statsWorse);
        pA2.setPlayerStats(statsWorse);
        pA3.setPlayerStats(statsWorse);
        pA4.setPlayerStats(statsWorse);
        pA5.setPlayerStats(statsWorse);

        pB1.setPlayerStats(statsWorse);
        pB2.setPlayerStats(statsWorse);
        pB3.setPlayerStats(statsWorse);
        pB4.setPlayerStats(statsWorse);
        pB5.setPlayerStats(statsWorse);

        TeamA.add(pA1);
        TeamA.add(pA2);
        TeamA.add(pA3);
        TeamA.add(pA4);
        TeamA.add(pA5);

        TeamB.add(pB1);
        TeamB.add(pB2);
        TeamB.add(pB3);
        TeamB.add(pB4);
        TeamB.add(pB5);

        assertEquals(MatchResult.TIE, match.matchResult(TeamA,TeamB));

    }

    @Test
    void shouldReturnTeamAWinner() {
        Player pA1 = new Player(), pA2 = new Player(), pA3 = new Player(), pA4 = new Player(), pA5 = new Player(),
                pB1 = new Player(), pB2 = new Player(), pB3 = new Player(), pB4 = new Player(), pB5 = new Player();

        PlayerStats statsBetter = new PlayerStats(), statsWorse = new PlayerStats();

        statsBetter.setMechanics(200);
        statsBetter.setPositioning(200);


        List<Player> TeamA = new LinkedList<>(), TeamB = new LinkedList<>();

        pA1.setPlayerStats(statsBetter);
        pA2.setPlayerStats(statsBetter);
        pA3.setPlayerStats(statsBetter);
        pA4.setPlayerStats(statsWorse);
        pA5.setPlayerStats(statsWorse);

        pB1.setPlayerStats(statsBetter);
        pB2.setPlayerStats(statsBetter);
        pB3.setPlayerStats(statsWorse);
        pB4.setPlayerStats(statsWorse);
        pB5.setPlayerStats(statsWorse);

        TeamA.add(pA1);
        TeamA.add(pA2);
        TeamA.add(pA3);
        TeamA.add(pA4);
        TeamA.add(pA5);

        TeamB.add(pB1);
        TeamB.add(pB2);
        TeamB.add(pB3);
        TeamB.add(pB4);
        TeamB.add(pB5);

        assertEquals(MatchResult.TEAM_A_WIN, match.matchResult(TeamA,TeamB));

    }

    @Test
    void shouldReturnTeamBWinner() {
        Player pA1 = new Player(), pA2 = new Player(), pA3 = new Player(), pA4 = new Player(), pA5 = new Player(),
                pB1 = new Player(), pB2 = new Player(), pB3 = new Player(), pB4 = new Player(), pB5 = new Player();

        PlayerStats statsBetter = new PlayerStats(), statsWorse = new PlayerStats();

        statsBetter.setMechanics(200);
        statsBetter.setPositioning(200);


        List<Player> TeamA = new LinkedList<>(), TeamB = new LinkedList<>();

        pA1.setPlayerStats(statsWorse);
        pA2.setPlayerStats(statsWorse);
        pA3.setPlayerStats(statsWorse);
        pA4.setPlayerStats(statsWorse);
        pA5.setPlayerStats(statsWorse);

        pB1.setPlayerStats(statsBetter);
        pB2.setPlayerStats(statsBetter);
        pB3.setPlayerStats(statsWorse);
        pB4.setPlayerStats(statsWorse);
        pB5.setPlayerStats(statsWorse);

        TeamA.add(pA1);
        TeamA.add(pA2);
        TeamA.add(pA3);
        TeamA.add(pA4);
        TeamA.add(pA5);

        TeamB.add(pB1);
        TeamB.add(pB2);
        TeamB.add(pB3);
        TeamB.add(pB4);
        TeamB.add(pB5);

        assertEquals(MatchResult.TEAM_B_WIN, match.matchResult(TeamA,TeamB));

    }

}