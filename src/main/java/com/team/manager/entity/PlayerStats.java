package com.team.manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int mechanics;

    private int mapAwareness;

    private int laningPhase;

    private int teamfighting;

    private int positioning;

    @JsonIgnore
    @OneToOne(mappedBy = "playerStats",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Player player;

    public PlayerStats() {
    }

    public PlayerStats(int id, int mechanics, int mapAwareness, int laningPhase, int teamfighting, int positioning) {
        this.id = id;
        this.mechanics = mechanics;
        this.mapAwareness = mapAwareness;
        this.laningPhase = laningPhase;
        this.teamfighting = teamfighting;
        this.positioning = positioning;
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
                '}';
    }
}
