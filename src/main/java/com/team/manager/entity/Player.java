package com.team.manager.entity;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String nick;

    private String role;

    private String age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id", nullable = false)
    private PlayerStats playerStats;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    public Player() {
    }

    public Player(int id, String name, String surname, String nick, String role, String age, PlayerStats playerStats, Team team) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.role = role;
        this.age = age;
        this.playerStats = playerStats;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nick='" + nick + '\'' +
                ", role='" + role + '\'' +
                ", age='" + age + '\'' +
                ", playerId=" + playerStats +
                ", teamId=" + team +
                '}';
    }
}