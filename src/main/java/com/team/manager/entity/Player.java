package com.team.manager.entity;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nick")
    private String nick;

    @Column(name = "role")
    private String role;

    @Column(name = "age")
    private String age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id")
    private int statsId;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "team_id")
    private int teamId;

    public Player() {
    }

    public Player(int id, String name, String surname, String nick, String role, String age, int statsId, int teamId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nick = nick;
        this.role = role;
        this.age = age;
        this.statsId = statsId;
        this.teamId = teamId;
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

    public int getStatsId() {
        return statsId;
    }

    public int getTeamId() {
        return teamId;
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
                ", playerId=" + statsId +
                ", teamId=" + teamId +
                '}';
    }
}