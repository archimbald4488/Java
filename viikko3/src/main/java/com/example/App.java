package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main( String[] args ) {
        InputStreamReader defaultInputReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(defaultInputReader);
        Scanner bufferedScanner = new Scanner(bufferedReader);

        Safe safe = new Safe("0000");


        while (true) {
            System.out.println("1) Aseta PIN-koodi");
            System.out.println("2) Lisää tietoja kansioon");
            System.out.println("3) Listaa tiedot kansiosta");
            System.out.println("0) Lopeta ohjelma");

            int choice;
            choice = Integer.parseInt(bufferedScanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Anna uusi PIN-koodi:\n");
                    safe.uusiPIN(bufferedScanner.nextLine());
                    break;

                case 2:
                    System.out.print("Anna kansioon lisättävä tieto:\n");
                    safe.addItem(bufferedScanner.nextLine());
                    break;

                case 3:
                    System.out.print("Anna PIN-koodi:\n");
                    var asiat = safe.listItems(bufferedScanner.nextLine());
                    if (asiat != null) {
                        for (String asia : asiat) {
                            System.out.println(asia);
                        }
                    } else {
                        System.out.println("Väärä PIN-koodi!");
                    }
                    break;

                case 0:
                    System.out.println("Kiitos ohjelman käytöstä.");
                    bufferedScanner.close();
                    return;

                default:
                    System.out.println("Väärä syöte.");
            }
        }
    }
}
