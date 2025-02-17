package com.example;

import java.io.Serializable;

public class Monster implements Serializable {
    private String monstertype;
    private int healthpoints;

    public Monster(String type, int health) {
        this.monstertype = type;
        this.healthpoints = health;
    }

    public void printInfo(int number) {
        System.out.println("\n" + number + ": " + monstertype + " / " + healthpoints + "HP");
    }

    public String monsterType() {
        return monstertype;
    }
    
    public boolean takeDamage(int damage) {
        healthpoints -= damage;
        if (healthpoints <= 0) {
            System.out.println(monstertype + " on kuollut!");
            return false;
        }
        System.out.println("Hirviöllä on " + healthpoints + " elämää jäljellä.");
        return true;
    }
}
