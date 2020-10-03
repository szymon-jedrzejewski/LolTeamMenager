package com.team.manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Surname is mandatory")
    private String surname;

    @NotNull(message = "Nick is mandatory")
    private String nick;

    @NotNull(message = "Role is mandatory")
    private String role;

    @NotNull(message = "Age is mandatory")
    @Min(value = 16, message = "Player is to young.")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
    private PlayerStats playerStats;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {
    }

    public Player(String name, String surname, String nick, String role, int age) {
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.role = role;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public Team getTeam() {
        return team;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public void setTeam(Team team) {
        this.team = team;
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
                ", playerStats=" + playerStats +
                ", team=" + team +
                '}';
    }
}