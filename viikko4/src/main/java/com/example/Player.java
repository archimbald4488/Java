package com.example;

import java.io.Serializable;

public class Player implements Serializable {
    private String playername;

    public Player(String name) {
        this.playername = name;
    }

    public String getPlayername() {
        return playername;
    }

    public boolean attack(Monster target) {
        System.out.println(playername + " hyökkää " + target.monsterType() + " hirviöön!");
        if (target.takeDamage(10) == false) {
            return false;
        }
        return true;
    }
}