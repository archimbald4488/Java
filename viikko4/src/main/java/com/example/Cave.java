package com.example;

import java.io.*;
import java.util.ArrayList;

public class Cave implements Serializable {
    private Player activeplayer;
    private ArrayList<Monster> monsters;
    private int n;

    public Cave(Player player) {
        this.activeplayer = player;
        this.monsters = new ArrayList<>();
    }

    public String getName() {
        return activeplayer.getPlayername();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void listMonsters() {
        n = 1;
        if (monsters.size() == 0) {
            System.out.println("Luola on tyhjä.");
        } else {
            System.out.print("Luolan hirviöt:");
            for (Monster monster : monsters) {
                monster.printInfo(n);
                n++;
            }
        }
    }

    public void cheat() {
        n = 1;
        if (monsters.size() == 0) {
            System.out.println("Luola on tyhjä.");
        } else {
            for (Monster monster : monsters) {
                monster.printInfo(n);
                n++;
            }
        }
    }

    public void attackMonster(int index) {
        if (index >= 0 && index < monsters.size()) {
            Monster target = monsters.get(index);
            if (activeplayer.attack(target) == false) {
                monsters.remove(index);
            }
        } else {
            System.out.println("Sitä numeroa ei ole listassa.");
        }
    }

    public void saveGame(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
            System.out.println("Peli tallennettiin tiedostoon " + filename + ".");
        } catch (IOException e) {
            System.out.println("Tallennus epäonnistui: " + e.getMessage());
        }
    }

    public static Cave loadGame(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Cave) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lataus epäonnistui: " + e.getMessage());
            return null;
        }
    }
}
