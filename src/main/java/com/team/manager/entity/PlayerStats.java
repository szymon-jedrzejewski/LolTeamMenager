package com.team.manager.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mechanics")
    private int mechanics;

    @Column(name = "map_awareness")
    private int mapAwareness;

    @Column(name = "laning_phase")
    private int laningPhase;

    @Column(name = "teamfighting")
    private int teamfighting;

    @Column(name = "positioning")
    private int positioning;

    private int[] statArray;

    public PlayerStats() {
    }

    public PlayerStats(int mechanics, int mapAwareness, int laningPhase, int teamfighting, int positioning) {
        this.mechanics = mechanics;
        this.mapAwareness = mapAwareness;
        this.laningPhase = laningPhase;
        this.teamfighting = teamfighting;
        this.positioning = positioning;

        this.statArray = new int[]{mechanics
                , mapAwareness
                , laningPhase
                , teamfighting
                , positioning};
    }

    public PlayerStats(int id, int mechanics, int mapAwareness, int laningPhase, int teamfighting, int positioning) {
        this.id = id;
        this.mechanics = mechanics;
        this.mapAwareness = mapAwareness;
        this.laningPhase = laningPhase;
        this.teamfighting = teamfighting;
        this.positioning = positioning;
        this.statArray = new int[]{mechanics
                , mapAwareness
                , laningPhase
                , teamfighting
                , positioning};
    }

    public int[] getStatArray() {
        return statArray;
    }

    public void setStatArray(int[] statArray) {
        this.statArray = statArray;
    }

    public int getId() {
        return id;
    }

    public int getMechanics() {
        return mechanics;
    }

    public void setMechanics(int mechanics) {
        this.mechanics = mechanics;
    }

    public int getMapAwareness() {
        return mapAwareness;
    }

    public void setMapAwareness(int mapAwareness) {
        this.mapAwareness = mapAwareness;
    }

    public int getLaningPhase() {
        return laningPhase;
    }

    public void setLaningPhase(int laningPhase) {
        this.laningPhase = laningPhase;
    }

    public int getTeamfighting() {
        return teamfighting;
    }

    public void setTeamfighting(int teamfighting) {
        this.teamfighting = teamfighting;
    }

    public int getPositioning() {
        return positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "id=" + id +
                ", mechanics=" + mechanics +
                ", mapAwareness=" + mapAwareness +
                ", laningPhase=" + laningPhase +
                ", teamfighting=" + teamfighting +
                ", positioning=" + positioning +
                ", statArray=" + Arrays.toString(statArray) +
                '}';
    }
}
