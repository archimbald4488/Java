package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class App {
    public static void main( String[] args ) {
        InputStreamReader defaultInputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(defaultInputReader);
        Scanner bufferedScanner = new Scanner(bufferedReader);

        String dude;

        System.out.print("Syötä pelaajan nimi:\n");
        dude = bufferedScanner.nextLine();
        Cave cave = new Cave(new Player(dude));

        while (true) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            int choice;
            choice = Integer.parseInt(bufferedScanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Anna hirviön tyyppi:\n");
                    String type = bufferedScanner.nextLine();
                    System.out.print("Anna hirviön elämän määrä numerona:\n");
                    int hp = Integer.parseInt(bufferedScanner.nextLine());
                    cave.addMonster(new Monster(type, hp));
                    break;

                case 2:
                    cave.listMonsters();
                    break;

                case 3:
                    System.out.print("Valitse hirviö, johon hyökätä:");
                    cave.cheat();
                    int index = Integer.parseInt(bufferedScanner.nextLine());
                    cave.attackMonster(index - 1);
                    break;

                case 4:
                    System.out.print("Anna tiedoston nimi, johon peli tallentaa:\n");
                    String file1 = bufferedScanner.nextLine();
                    cave.saveGame(file1);
                    break;

                case 5:
                    System.out.print("Anna tiedoston nimi, josta peli ladataan:\n");
                    String file2 = bufferedScanner.nextLine();
                    Cave loadedCave = Cave.loadGame(file2);
                    if (loadedCave != null) {
                        cave = loadedCave;
                        System.out.println("Peli ladattu tiedostosta " + file2 + ". Tervetuloa takaisin, " + cave.getName() + ".");
                    }
                    break;

                case 0:
                    System.out.print("Peli päättyy. Kiitos pelaamisesta!\n");
                    bufferedScanner.close();
                    return;

                default:
                    System.out.println("Väärä syöte.");
            }
        }
    }
}